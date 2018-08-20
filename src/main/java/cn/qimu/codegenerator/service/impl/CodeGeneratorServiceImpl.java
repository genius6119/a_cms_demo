package cn.qimu.codegenerator.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qimu.codegenerator.dao.CodeGeneratorDao;
import cn.qimu.codegenerator.service.CodeGeneratorService;
import cn.qimu.codegenerator.utils.GenUtils;

@Service("sysGeneratorService")
public class CodeGeneratorServiceImpl implements CodeGeneratorService {
	@Autowired(required = false)
	private CodeGeneratorDao sysGeneratorDao;

	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		return sysGeneratorDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysGeneratorDao.queryTotal(map);
	}

	@Override
	public Map<String, String> queryTable(String tableName) {
		return sysGeneratorDao.queryTable(tableName);
	}

	@Override
	public List<Map<String, String>> queryColumns(String tableName) {
		return sysGeneratorDao.queryColumns(tableName);
	}

	@Override
	public byte[] generatorCode(String[] tableNames) {

		String zipPath = "D:/src_gen/";
		String zipName = "src_file";
		FileOutputStream fos = null;
		// ZipOutputStream zos = null;

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		try {

			if (!new File(zipPath).exists()) {
				new File(zipPath).mkdirs();
			}
			File zipFile = new File(zipPath + "/" + zipName + ".zip");
			
			System.out.println("输出路径："+zipPath + "/" + zipName + ".zip");

			fos = new FileOutputStream(zipFile);
			zip = new ZipOutputStream(fos);

			for (String tableName : tableNames) {
				// 查询表信息
				Map<String, String> table = queryTable(tableName);
				// 查询列信息
				List<Map<String, String>> columns = queryColumns(tableName);
				// 生成代码
				GenUtils.generatorCode(table, columns, zip);
			}

			IOUtils.closeQuietly(zip);

			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
		}

		return outputStream.toByteArray();
	}

}
