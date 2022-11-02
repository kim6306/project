<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml><html><head><title>${title}</title><link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet"></head><body><div id="header"><h1>${title}</h1></div><div class="container">
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<input type="button" value="เพิ่มสินค้า"onclick="window.location.href='${pageContext.request.contextPath}/shop/${shop.id}/product/add';return false;"class="add-button"/>
<table class="table-bordered">
  <thead>
  <tr>
    <th>รหัสสินค้า</th>
    <th>ชื่อสินค้า</th>
    <th>ราคา</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody><c:forEach var="product" items="${products}">
    <tr>
      <td class="center"><a href="${pageContext.request.contextPath}/product/${product.id}/update">${product.code}</a></td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td class="center"><a href="${pageContext.request.contextPath}/shop/${shop.id}/product/${product.id}/remove">ลบ</a></td>
    </tr>
  </c:forEach></tbody>
</table>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>