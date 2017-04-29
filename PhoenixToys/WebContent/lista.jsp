<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-6">
	<h1>Lista de brinquedos</h1>
</div>

<br>
<div class="col-sm-5">
	<form action="administracao" method="GET" class="form-inline">
		<div class="form-group">
			<input type="hidden" name="action" value="search"> <input
				type="text" name="pesquisa" class="form-control"> <input
				type="submit" class="btn btn-primary" value="Buscar"
				class="form-control">
		</div>
	</form>

</div>

<br>
<table border="1" class="table table-hover">
	<tr bgcolor="silver">
		<th>DESCRICAO</th>
		<th>CATEGORIA</th>
		<th>PREÇO</th>
		<th colspan="2" align="right">CONTROLES</th>

	</tr>

	<c:forEach items="${brinquedos}" var="brinquedo" varStatus="contador">
		<tr bgcolor="white">
		



			<td>${brinquedo.descricao}</td>
			<td>${brinquedo.categoria}</td>
			<td>R$${brinquedo.preco}</td>
			<td><a type="button" class="btn btn-danger" data-cod="${brinquedo.cod}" data-toggle="modal"
				data-target="#${brinquedo.cod}" >Excluir</a></td>
				
			<td><a
				href="administracao?action=editar&cod=${brinquedo.cod}"
				class="btn btn-default">Editar</a></td>
		</tr>


		<div class="modal fade" id="${brinquedo.cod}">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">x</span>
						</button>
						<h3 class="modal-title">Exclusão</h3>
					</div>
					<div class="modal-body">
						<p>Tem certeza que deseja excluir o brinquedo?</p>
					</div>
					<div class="modal-footer">
						<a id="link" href="administracao?action=excluir&cod=${brinquedo.cod}"
							class="btn btn-primary">Excluir</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					</div>
				</div>
			</div>
		</div>




	</c:forEach>
</table>








<a class="btn btn-primary" href="administracao?action=cadastrar">
	Novo Brinquedo</a>
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>