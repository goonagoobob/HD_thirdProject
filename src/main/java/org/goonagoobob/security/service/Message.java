
/*********************************
 * @function : 에러 메시지 
 * @author : 이세은
 * @Date : Feb 12. 2023
 * 
 *********************************/

package org.goonagoobob.security.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
	String message = "";
	String href = "";
	
	public Message(String message, String href) {
		this.message = message;
		this.href = href;
	}
}
