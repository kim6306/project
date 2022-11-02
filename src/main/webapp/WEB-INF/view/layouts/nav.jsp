<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/logout" method="POST" name="frmLogout"></form:form>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}">หน้าหลัก</a></li>
        <security:authorize access="hasRole('MEMBER')">
            <li><a href="${pageContext.request.contextPath}/product/list">รายการสินค้า</a></li>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <li><a href="${pageContext.request.contextPath}/shop/list">รายการร้านค้า</a></li>
        </security:authorize>
        <security:authorize access="!isAuthenticated()">
            <li><a href="${pageContext.request.contextPath}/login">ลงชื่อเข้าสู่ระบบ</a></li>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <li><a onclick="javascript: frmLogout.submit();">ลงชื่อออกจากระบบ</a></li>
            <li>ชื่อผู้ใช้: <security:authentication property="principal.username"/></li>
        </security:authorize>
    </ul>
</nav>
<hr>
