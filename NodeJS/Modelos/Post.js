const db = require('./Db')

const Post = db.sequelize.define('postagens',{
    //campos do banco de dados
    titulo: {
        type: db.Sequelize.TEXT
    },
    conteudo:{
        type: db.Sequelize.TEXT
    },
   // emissor:{
   //     type: db.Sequelize.STRING
   // }
})

//executar apenas uma única vez
//Post.sync({force: true})

module.exports = Post