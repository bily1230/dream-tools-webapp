package com.dream.java.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest {

	public static void main(String[] args) throws Exception {

		String zipPath = "/home/nb/桌面";
		String srcPath = "/home/nb/桌面/yyy";
		String zipName = "test.zip";

		 zip(srcPath, zipPath, zipName);
		unZip(zipPath + File.separator + zipName, zipPath);

	}

	/**
	 * 
	 * @Description: TODO
	 * @param @param srcPath 压缩包位置
	 * @param @param toPath 解压到文件路径
	 * @return void
	 */
	public static void unZip(String zipFilePath, String unZipPath) {
		try {
			ZipFile zipFile = new ZipFile(zipFilePath);

			File unFileDir = new File(unZipPath);
			if (!unFileDir.exists() || !unFileDir.isDirectory()) {
				unFileDir.mkdirs();
			}
			ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
			ZipEntry zipEntry = null;
			while ((zipEntry = zipIn.getNextEntry()) != null) {
				if (!zipEntry.isDirectory()) {
					String entryPath = unZipPath + File.separator + zipEntry.getName();
					File entryFile = new File(entryPath);
					if (!entryFile.exists()) {
						new File(entryFile.getParent()).mkdirs();
					}

					BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream(entryPath));
					BufferedInputStream bufferIn = new BufferedInputStream(zipFile.getInputStream(zipEntry));

					int b = -1;
					byte[] buf = new byte[1024];
					while ((b = bufferIn.read(buf)) != -1) {
						bufferOut.write(buf, 0, b);
					}
					bufferOut.flush();
					bufferOut.close();

				} else {

				}
			}
			zipIn.closeEntry();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: TODO
	 * @param @param srcPath 需要压缩文件路径
	 * @param @param zipPath 压缩文件存储目录
	 * @param @param zipName 压缩文件名
	 * @return void
	 */
	public static void zip(String srcPath, String zipPath, String zipName) {

		ZipOutputStream out = null;

		File srcFile = new File(srcPath);
		File zipDir = new File(zipPath);
		if (!zipDir.exists() || !zipDir.isDirectory()) {
			zipDir.mkdirs();
		}

		String zipFilePath = zipPath + File.separator + zipName;

		File zipFile = new File(zipFilePath);
		if (zipFile.exists()) {
			return;
		}
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFile));
			zipFile(srcFile, out, "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void zipFile(File file, ZipOutputStream out, String zipPath) {
		if (!file.exists()) {
			return;
		}
		if (file.isFile()) {
			String realPath = zipPath + File.separator + file.getName();
			FileInputStream in = null;
			try {
				in = new FileInputStream(file);
				ZipEntry zipEntry = new ZipEntry(realPath);
				out.putNextEntry(zipEntry);
				int len = 0;
				byte[] buff = new byte[1024];
				while ((len = in.read(buff)) > 0) {
					out.write(buff, 0, len);
				}
				out.closeEntry();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			File[] files = file.listFiles();
			for (File childFile : files) {
				// 如果是目录则存储路径需要添加目录名
				String path = zipPath + File.separator + file.getName();
				zipFile(childFile, out, path);
			}
		}

	}

}
