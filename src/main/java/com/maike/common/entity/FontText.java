package com.maike.common.entity;

 /**
 * @ClassName: FontText
 * @Description:
 * @author: geekplus
 * @date: 2018年8月30日 下午4:06:55
 */
public class FontText {

	private String text;

    private int wm_text_pos;

    private String wm_text_color;

    private Integer wm_text_size;

    private String wm_text_font;//字体  “黑体，Arial”

	public FontText() {
	}


	/**
	 * @param text
	 * @param wm_text_pos
	 * @param wm_text_color
	 * @param wm_text_size
	 * @param wm_text_font
	 */
	public FontText(String text, int wm_text_pos, String wm_text_color, Integer wm_text_size, String wm_text_font) {
		this.text = text;
		this.wm_text_pos = wm_text_pos;
		this.wm_text_color = wm_text_color;
		this.wm_text_size = wm_text_size;
		this.wm_text_font = wm_text_font;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the wm_text_pos
	 */
	public int getWm_text_pos() {
		return wm_text_pos;
	}

	/**
	 * @param wm_text_pos the wm_text_pos to set
	 */
	public void setWm_text_pos(int wm_text_pos) {
		this.wm_text_pos = wm_text_pos;
	}

	/**
	 * @return the wm_text_color
	 */
	public String getWm_text_color() {
		return wm_text_color;
	}

	/**
	 * @param wm_text_color the wm_text_color to set
	 */
	public void setWm_text_color(String wm_text_color) {
		this.wm_text_color = wm_text_color;
	}

	/**
	 * @return the wm_text_size
	 */
	public Integer getWm_text_size() {
		return wm_text_size;
	}

	/**
	 * @param wm_text_size the wm_text_size to set
	 */
	public void setWm_text_size(Integer wm_text_size) {
		this.wm_text_size = wm_text_size;
	}

	/**
	 * @return the wm_text_font
	 */
	public String getWm_text_font() {
		return wm_text_font;
	}

	/**
	 * @param wm_text_font the wm_text_font to set
	 */
	public void setWm_text_font(String wm_text_font) {
		this.wm_text_font = wm_text_font;
	}

}
