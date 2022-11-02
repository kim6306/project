<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>${title}</title>
  <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
</head>
<body><h1>${title}</h1>
<div class="container">
  <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
  <input type="button" value="เพิ่มร้านค้า"
         onclick="window.location.href='${pageContext.request.contextPath}/shop/create'; return false;"class="add-button"/>
  <table>
    <thead>
    <tr>
      <th>รหัสร้านค้า</th>
      <th>ชื่อร้านค้า</th>
      <th>เจ้าของ</th>
      <th>ละติจูด</th>
      <th>ลองจิจูด</th>
      <th>จำนวนสินค้า</th>
    </tr>
    </thead>
    <tbody><c:forEach var="shop" items="${shops}">
      <tr>
        <td><a href="${pageContext.request.contextPath}/shop/${shop.id}/update">${shop.code}</a></td>
        <td>${shop.name}</td>
        <td>${shop.owner}</td>
        <td>${shop.latitude}</td>
        <td>${shop.longitude}</td>
        <td>${fn:length(shop.products)}</td>
      </tr>
    </c:forEach></tbody>
  </table>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>