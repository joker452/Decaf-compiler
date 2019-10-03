package decaf.utils;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * 用于缩进输出的类<br>
 * 使用时注意不要自行输出"\r\n"或"\n"进行换行，而要使用该类的println系列函数进行换行<br>
 * 
 *   
 * 
 */
public class IndentPrintWriter extends PrintWriter {
	private int step;

	private StringBuilder indent;

	private boolean newLineBegin;

	/**
	 * 
	 * @param out
	 * @param step
	 *            每次缩进变化的空格数
	 */
	public IndentPrintWriter(OutputStream out, int step) {
		this(new OutputStreamWriter(out), step);
	}

	/**
	 * 
	 * @param out
	 * @param step
	 *            每次缩进变化的空格数
	 */
	public IndentPrintWriter(Writer out, int step) {
		super(out);
		this.step = step;
		indent = new StringBuilder();
		newLineBegin = true;
	}

	/**
	 * 增加缩进
	 */
	public void incIndent() {
		for (int i = 0; i < step; i++) {
			indent.append(" ");
		}
	}

	/**
	 * 减少缩进
	 */
	public void decIndent() {
		indent.setLength(indent.length() - step);
	}

	@Override
	public void println() {
		super.println();
		newLineBegin = true;
	}
	
	/**
	 * 输出缩进，只在行首有效
	 */
	private void writeIndent() {
		if (newLineBegin) {
			newLineBegin = false;
			print(indent);
		}
	}

	/**
	 * 输出缩进后，输出字符数组
	 * @param buf - Array of characters
         * @param off - Offset from which to start writing characters
         * @param len - Number of characters to write
	 */
	@Override
	public void write(char[] buf, int off, int len) {
		writeIndent();
		super.write(buf, off, len);
	}

	/**
	 * 输出缩进后，输出整数
	 * @param c - The int to be printed
	 */
	@Override
	public void write(int c) {
		writeIndent();
		super.write(c);
	}

	/**
	 * 输出缩进后，输出字符串
	 * @param s - A String
         * @param off - Offset from which to start writing characters
	 * @param len - Number of characters to write
	 */
	@Override
	public void write(String s, int off, int len) {
		writeIndent();
		super.write(s, off, len);
	}

}
