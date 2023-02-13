/*********************************
 * @function : File DTO
 * @author : 조일우
 * @Date : Feb 13. 2023
 * 파일 DTO 추가 Feb 13. 2023
 *********************************/

package org.goonagoobob.domain.product;

import lombok.Data;

@Data
public class FileDto {
	private String FILE_UUID;
	private String UPLOADPATH;
	private String FILENAME;	// 실제 파일 이름
    private String FILETYPE;
}
