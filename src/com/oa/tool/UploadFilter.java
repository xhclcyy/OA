package com.oa.tool;

public class UploadFilter {

	public static String getSuffix(String originalFilename)
			throws UploadException {

		if (originalFilename == null || originalFilename.length() == 0) {
			throw new UploadException("未选中任何文件");
		}

		int start = originalFilename.lastIndexOf(".");

		if (start == -1) {
			throw new UploadException("文件类型不正确");
		}

		String suffix = originalFilename.substring(start + 1,
				originalFilename.length());

		if (suffix == null || suffix.length() == 0) {
			throw new UploadException("文件类型不正确");
		}

		return suffix;
	}

}
