//conexão banco de dados mysql
const Sequelize = require('sequelize')

//conexão com banco de dados POSTAGENS
const sequelize = new Sequelize('postagens', 'root', 'rafavedi23', {
    host: "localhost",
    dialect: "mysql"
})

module.exports = {
    Sequelize: Sequelize,
    sequelize: sequelize
}