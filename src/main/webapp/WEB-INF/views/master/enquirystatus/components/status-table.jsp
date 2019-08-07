
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">Responsive Hover Table</h3>

                <div class="box-tools">
                    <div class="input-group input-group-sm" style="width: 150px;">
                        <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">

                        <div class="input-group-btn">
                            <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.box-header -->

            <div class="box-body table-responsive no-padding">

<table class="table table-hover">
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>Color</th>
</thead>
<tbody>

    <c:forEach var="status" items="${statuses}">
        <tr>
            <td>${status.id}</td>
            <td>${status.name}</td>
            <td style="background:${status.color}">${status.color}</td>
            <td> <a href="javascript:void(0)" data-id="${status.id}" class="edit-btn btn btn-success btn-xs" title="Edit Enquiry Status">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a> 


                <a href= "${pageContext.request.contextPath}/admin/master/enquiry/status/delete/${status.id}" class="btn btn-danger btn-xs" title="Delete Enquiry Status">
                    <span class="glyphicon glyphicon-trash"></span>
                </a></td>
        </tr>
    </c:forEach>

</tbody>

</table>
            </div>
        </div>


<script>

    $(".edit-btn").on('click',function() {
    let $id = $(this).attr('data-id');
            $.getJSON('${pageContext.request.contextPath}/admin/master/enquiry/status/'+$id, function(data){
            $("#status-id").val(data.id);
            $("#status-name").val(data.name);
            $("#status-color").val(data.color);
    let $dialog = $('#status-dialog');
            $dialog.find('.modal-title').html('Edit Enquiry Status');
            $dialog.modal();
    });
    });


</script>