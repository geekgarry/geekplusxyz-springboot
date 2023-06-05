package com.maike.common.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 *
 * @ClassName VideoItem
 * @Description 视频消息实体
 * @Author Garry
 * @Date 2018年5月23日 上午10:50:48
 */
public class VideoItem {

	private Integer width;
	private Integer height;
	private Long size;
	private Long time;
	private String format;

	public VideoItem() {
	}
	public VideoItem(Integer width, Integer height, Long size, Long time, String format) {
		this.width = width;
		this.height = height;
		this.size = size;
		this.time = time;
		this.format = format;
	}

	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormatTime(){
		return getTime()/ 60000 + "分" + (getTime()) / 1000 + "秒";
	}
	public String getFormatSize(){
		BigDecimal fileSize = new BigDecimal(getSize());
		return fileSize.divide(new BigDecimal(1048576), 2, RoundingMode.HALF_UP) + "MB";
	}
	@Override
	public String toString() {
		return "VideoInfo [width=" + width + ", height=" + height + ", size=" + getFormatSize() + ", time=" + getFormatTime() + ", format="
				+ format + "]";
	}
	public static void main(String[] args) {
		System.out.println(new VideoItem(100,100,100000L,new Date().getTime(),"jpg"));
	}
}
