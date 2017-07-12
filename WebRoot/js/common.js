function _change() {
	$("#vCode").attr("src", "/goodplus/VerifyCodeServlet?" + new Date().getTime());
}