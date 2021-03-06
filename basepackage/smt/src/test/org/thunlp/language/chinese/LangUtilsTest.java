package org.thunlp.language.chinese;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.thunlp.language.chinese.LangUtils;

public class LangUtilsTest extends TestCase {
	public void testFilterSpace() {
		String src = "  中文的空格     其中夹杂着\u000B\u000Bsome English words但是\n下一行的  空格　　中文空格";
		String standard = "中文的空格 其中夹杂着 some English words但是\n下一行的 空格 中文空格";
		String result = LangUtils.removeExtraSpaces(src);
		Assert.assertEquals(standard, result);
	}

	public void testFilterEmptyLines() {
		String src = "line1\nline2\r\n\r\n\nline3\n\n\r\n";
		String standard = "line1\nline2\nline3\n";
		String result = LangUtils.removeEmptyLines(src);
		Assert.assertEquals(standard, result);
	}

	public void testFilterMarks() {
		String src = "中文,\"其中\"的各种：标点符号.。“”都出现了／～";
		String standard = "中文 其中 的各种 标点符号 都出现了";
		String result = LangUtils.removePunctuationMarks(src);
		Assert.assertEquals(standard, result);
	}

	public void testMapMarks() {
		String src = "“这个程序”能把‘所有’的中文标点，都变换成ANSI的么？是的！";
		String standard = "\"这个程序\"能把'所有'的中文标点,都变换成ANSI的么?是的!";
		String result = LangUtils.mapChineseMarksToAnsi(src);
		Assert.assertEquals(standard, result);
	}

	public void testFilterLineEnds() {
		String src = "line1\nline2\r\n\r\n\nline3\n\n\r\n";
		String standard = "line1 line2 line3";
		String result = LangUtils.removeLineEnds(src);
		Assert.assertEquals(standard, result);
	}

	public void testNumbers() {
		String src = "国民生产总值达到100万!";
		String standard = "国民生产总值达到100万";
		String result = LangUtils.removePunctuationMarks(src);
		Assert.assertEquals(standard, result);
	}

	public void testT2SAndS2T() {
		String t = "Google 非常重視您的隱私。本文概述我們在您使用 Google 服務時所接收和收集的個人資料種類";
		String s = "Google 非常重视您的隐私。本文概述我们在您使用 Google 服务时所接收和收集的个人资料种类";

		String t2s = LangUtils.T2S(t);
		String s2t = LangUtils.S2T(s);

		Assert.assertEquals(t2s, s);
		Assert.assertEquals(s2t, t);
	}
}
