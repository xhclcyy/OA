package com.oa.tool;

/**
 * @author parox
 * 
 */
public class ImageUploadFilter {

	private enum include {
		JPEG, JPG, PNG, BMP, GIF;
	}

	public static void filter(String suffix) throws UploadException {

		// String suffix = UploadFilter.getSuffix(originalFilename);

		try {
			include.valueOf(suffix.toUpperCase());
		} catch (Exception e) {
			throw new UploadException(suffix + " 文件类型不允许上传");
		}

	}

}
