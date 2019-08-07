<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Enquires</h1>
</div>


<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">Enquires Table</h3>

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
                    <th>Email </th>
                    <th>Contact </th>
                    <th>Enquiry Date </th>
                    <th>Source</th>
                    <th>Status</th>
                    <th>Actions </th>
                    <th>Visited</th>
                    <th>FollowUp</th>
                    </thead>
                    <tbody>
                        <c:forEach var="enquiry" items="${enquires}">
                        <td>${enquiry.id}</td>
                        <td>${enquiry.firstName} ${enquiry.lastName}</td>
                        <td>${enquiry.email}</td>
                        <td>${enquiry.contactNumber}</td>
                        <td>${enquiry.createdDate}</td>
                        <td>${enquiry.source.name}</td>
                        <td>
                            <label class="label" style="background:${enquiry.status.color}">
                            ${enquiry.status.name}</td>

                        <td> <a href="javascript:void(0)" data-id="${enquiry.id}" class="edit-btn btn btn-success btn-xs" title="Edit Enquiry">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a> 


                            <a href= "${pageContext.request.contextPath}/admin/master/enquiry/status/delete/${enquiry.id}" class="btn btn-danger btn-xs" title="Delete Enquiry ">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a></td>

                        <td>
                            <c:choose>
                                <c:when test="${enquiry.visited}">
                                    Yes
                                </c:when>
                                <c:otherwise>
                                    <a href=""> Visited? </a>
                                </c:otherwise>
                            </c:choose>
                        </td>

                    </c:forEach>
                        
                         <td> <a href="javascript:void(0)" data-id="${enquiry.id}" class="edit-btn btn btn-default btn-xs" title="Edit Default">
                    <span class="glyphicon glyphicon-plus"></span>
                </a> 


                            <a href= "${pageContext.request.contextPath}/admin/master/enquiry/status/delete/${enquiry.id}" class="btn btn-danger btn-xs" title="Delete Enquiry ">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a></td>
                    </tbody>

                </table>

            </div>


            <script>

                $(".edit-btn").on('click', function() {
                let $id = $(this).attr('data-id');
                        $.getJSON('${pageContext.request.contextPath}/admin/master/enquiry/source/' + $id, function(data){
                        $("#source-id").val(data.id);
                                $("#source-name").val(data.name);
                                $("#source-color").val(data.color);
                                let $dialog = $('#source-dialog');
                                $dialog.find('.modal-title').html('Edit Enquiry Source');
                                $dialog.modal();
                        });
                });


            </script>

            <%@include file="../../shared/footer.jsp" %>