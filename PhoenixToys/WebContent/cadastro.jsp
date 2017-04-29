<br>
<br>
<h1>Administra��o: Cadastro de brinquedo</h1>

<form class="form-horizontal" action="administracao?action=cadastrar"
	method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="txtCod" class="control-label">COD:</label>
		<div class="controls">
			<input type="text" name="txtCod" id="txtCod"  class="form-control" required
				placeholder="C�digo"> <br>
		</div>
	</div>


	<div class="form-group">
		<label for="txtDescricao" class="control-label">Descri��o:</label>
		<div class="controls">
			<input type="text" name="txtDescricao"  id="txtDescricao"
				placeholder="Descri��o" class="form-control" required><br>
		</div>
	</div>

	<div class="form-group">
		<label for="txtCategoria" class="control-label">Categoria:</label>
			<select class="form-control" name="txtCategoria">
				<option value="Beb�">Beb�</option>
				<option value="Meninos">Meninos</option>
				<option value="Meninas">Meninas</option>
				<option value="Retr�">Retr�</option>
			</select>
		</div>

	<div class="form-group">
		<label for="txtMarca" class="control-label">Marca:</label>
		<div class="controls">
			<input type="text" name="txtMarca"  class="form-control" id="txtMarca" placeholder="Marca"
				required><br>
		</div>
	</div>

	<div class="form-group">
		<label for="txtImagem" class="control-label">Imagem:</label>
		<div class="controls">
			<input type="file" name="txtImagem"  class="form-control" id="txtImagem" required><br>
		</div>
	</div>


	<div class="form-group">
		<label for="txtPreco" class="control-label">Pre�o:</label>
		<div class="controls">
			<input type="text" name="txtPreco"  class="form-control" id="txtPreco" placeholder="Pre�o"
				required><br>
		</div>
	</div>
	<div class="form-group">
		<label for="txtDetalhes" class="control-label">Detalhes:</label>
		<div class="controls">
			<textarea name="txtDetalhes"  class="form-control" id="txtDetalhes" rows="5" cols="35"
				placeholder="Detalhes" required></textarea>
		</div>
	</div>

	<BR> <input type="submit" value="Salvar" class="btn btn-primary">
	<a href="administracao" class="btn btn-default">Voltar</a>


</form>
