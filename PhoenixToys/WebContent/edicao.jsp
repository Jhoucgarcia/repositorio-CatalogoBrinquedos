<br>
<br>
<h1>Administração: Edição de Brinquedo</h1>
<form class="form-horizontal" action="administracao?action=editar"
	method="post" enctype="multipart/form-data">
	<div class="control-group">
		<label for="txtCod" class="control-label">COD:</label>
		<div class="controls">
			<input type="text" class="form-control" name="txtCod" id="txtCod"
				value="${brinquedo.cod}" readonly> <br>
		</div>
	</div>


	<div class="control-group">
		<label for="txtDescricao" class="control-label">Descrição:</label>
		<div class="controls">
			<input type="text" class="form-control" name="txtDescricao"
				id="txtDescricao" value="${brinquedo.descricao }" required><br>
		</div>
	</div>

	<div class="control-group">
		<label for="txtCategoria" class="control-label">Categoria:</label> <select
			class="form-control" name="txtCategoria" required>
			<option></option selected>
			<option value="Bebê">Bebê</option>
			<option value="Meninos">Meninos</option>
			<option value="Meninas">Meninas</option>
			<option value="Retrô">Retrô</option>
		</select>
	</div>


	<div class="control-group">
		<label for="txtMarca" class="control-label">Marca:</label>
		<div class="controls">
			<input type="text" class="form-control" name="txtMarca" id="txtMarca"
				value="${brinquedo.marca }" required><br>
		</div>
	</div>

	<div class="control-group">
		<label for="txtImagem" class="control-label">Imagem:</label>
		<div class="controls">
			<input type="file" class="form-control" name="txtImagem"
				id="txtImagem" value="${brinquedo.imagem }" required><br>
		</div>
	</div>


	<div class="control-group">
		<label for="txtPreco" class="control-label">Preço:</label>
		<div class="controls">
			<input type="text" class="form-control" name="txtPreco" id="txtPreco"
				value="${brinquedo.preco }" required><br>
		</div>
	</div>
	<div class="control-group">
		<label for="txtDetalhes" class="control-label">Detalhes:</label>
		<div class="controls">
			<!-- <input type="text" name="txtDetalhes" id="txtDetalhes" value="${brinquedo.detalhes }"><br> -->
			<textarea name="txtDetalhes" class="form-control" id="txtDetalhes"
				rows="5" cols="35" required>${brinquedo.detalhes}</textarea>
		</div>
	</div>

	<BR> <input type="submit" value="Salvar" class="btn btn-primary">
	<a href="administracao" class="btn btn-default" role="button">Voltar</a>

</form>


