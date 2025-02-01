describe('Datatable', () => {
	
	beforeEach(() =>{
		cy.visit('datatable.jsf')
		cy.title('Datatable')
	})
	
	it ('Entrada.', () => {
		cy.contains('Nome:')
		cy.contains('UF:')
		cy.contains('Cidade:')
		cy.contains('Nenhum contato adicionado!')
	})
})