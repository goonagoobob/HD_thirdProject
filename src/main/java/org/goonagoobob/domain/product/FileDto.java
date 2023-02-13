package org.goonagoobob.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDto {
	private String FILE_UUID;
	private String UPLOADPATH;
	private String FILENAME;	// 실제 파일 이름
    private String FILETYPE;
}
