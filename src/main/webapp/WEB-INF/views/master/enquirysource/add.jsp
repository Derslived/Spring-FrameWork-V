<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1> Add Enquiry Source</h1>
    <form action="${SITE_URL}/admin/master/enquiry/source/" method="post">
    
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name" required="required" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Color</label>
            <input type="text" name="color" required="required" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-success">Save</button>
        <a href="${SITE_URL}/admin/master/enquiry/source" class="btn btn-danger "> Back</a>
    
    
    </form>
    
    
    
    
    
    
</div>




<%@include file="../../shared/footer.jsp" %>