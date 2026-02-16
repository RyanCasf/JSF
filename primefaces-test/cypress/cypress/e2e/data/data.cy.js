describe('Data', () => {

    beforeEach(() => {
        cy.visit('data.jsf')
    })

    it('Página ao abrir.', () => {
        cy.title().should('be.equals', 'Data')
        init()
    })
})

function init() {
    cy.get('#formularioData\\:informacao')
        .should('not.visible')

    cy.get('#formularioData\\:texto_data')
        .should('have.text', 'Data:')
        .should('have.css', 'display', 'block')

    cy.get('#formularioData\\:data')
        .should('be.visible')

    cy.get('#formularioData\\:imprimir')
        .should('have.text', 'Imprimir')
}