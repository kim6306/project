<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPEhtml><html><head><title>${title}</title></head><body><div id="header"><h1>${title}</h1></div><div class="container">
<jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
<div id="container"><i>กรอกข้อมูลในฟอร์ม. เครื่องหมายดอกจัน(*) หมายถึงห้ามว่าง</i><br><br><form:form action="${pageContext.request.contextPath}/shop/save"
                                                                                                     modelAttribute="shop"
                                                                                                     method="POST"><form:hidden
        path="id"/>
    <table>
        <colgroup>
            <col style="width: 160px;">
            <col style="width: auto;">
        </colgroup>
        <tbody>
        <tr>
            <td><label>รหัสร้านค้า:</label></td>
            <td><form:input path="code"/><form:errors path="code" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>ชื่อร้านค้า:</label></td>
            <td><form:input path="name"/><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>เจ้าของร้าน:</label></td>
            <td><form:input path="owner"/><form:errors path="owner" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>ละติจูด:</label></td>
            <td><form:input path="latitude"/><form:errors path="latitude" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>ลองจิจูด:</label></td>
            <td><form:input path="longitude"/><form:errors path="longitude" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>ที่อยู่:</label></td>
            <td><form:input path="address"/><form:errors path="address" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="บันทึก" class="save"/>
                <input type="button" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบสินค้านี้?'))) { window.location.href='${pageContext.request.contextPath}/shop/${shop.id}/delete'; return false; }"class="cancel-button"/>
                <!--<input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/shop/list'; return false;" class="cancel-button"/>-->
                <input type="button" value="แสดงสินค้า" onclick="window.location.href='${pageContext.request.contextPath}/shop/${shop.id}/view-products';return false;"/>
            </td>
        </tr>
        </tbody>
    </table>
</form:form></div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body></html>