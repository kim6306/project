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
    <input type="button" value="เพิ่มสินค้า"
           onclick="window.location.href='${pageContext.request.contextPath}/product/create'; return false;"class="add-button"/>
    <table>
        <thead>
        <tr>
            <th>รหัสสินค้า</th>
            <th>ชื่อสินค้า</th>
            <th>ราคา</th>
        </tr>
        </thead>
        <tbody><c:forEach var="product" items="${products}">
            <tr>
                <td><a href="${pageContext.request.contextPath}/product/${product.id}/update">${product.code}</a></td>
                <td>${product.name}</td>
                <td class="number"><fmt:formatNumber type="number" pattern="###,###.00" value="${product.price}"/></td>
            </tr>
        </c:forEach></tbody>
    </table>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>