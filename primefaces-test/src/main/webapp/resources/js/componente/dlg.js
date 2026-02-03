const dlg = document.getElementById('dlg');

dlg.show = function() {
	this.classList.remove('hidden');
};

dlg.hide = function() {
	this.classList.add('hidden');
};