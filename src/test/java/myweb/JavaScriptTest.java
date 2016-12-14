package myweb;

import org.unbescape.html.HtmlEscape;
import org.unbescape.javascript.JavaScriptEscape;


public class JavaScriptTest {
	public static void main(String[] args) {

		String filerText = "<script>alert(\"hello\")</script>";
		String text = JavaScriptEscape.escapeJavaScript(filerText);
		System.out.println(text);
		filerText = "<div><a href=''>abc</a></div>";
		text = HtmlEscape.escapeHtml5(filerText);
		System.out.println(text);

	} 
}
