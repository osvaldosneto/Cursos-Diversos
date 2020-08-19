//toda configuração passport AULA 58
const localStrategy = require("passport-local").Strategy
const mongoose = require("mongoose")
const bcrypt = require("bcryptjs")

//model de usuarios
require('../models/Usuario')
const Usuario = mongoose.model("usuario")

//configurando passport
module.exports = function(passport){
    //usando email como nome de login
    passport.use(new localStrategy({usernameField: "email", passwordField:"senha"}, (email, senha, done)=>{
        Usuario.findOne({email: email}).then((usuario)=>{
            if(!usuario){
                return done(null, false, {message: "Esta conta não existe."})
            }
            //comparando valores encriptados
            bcrypt.compare(senha, usuario.senha, (erro, batem)=>{
                if(batem){
                    return done(null, usuario)
                } else {
                    return done(null, false, {message: "Senha incorreta."})
                }
            })
        })
    })) 

    //salvando dados do usuario na secão manter logado
    passport.serializeUser((usuario, done)=>{
        done(null, usuario.id)
    })
    
    passport.deserializeUser((id, done)=>{
        Usuario.findById(id, (error, usuario)=>{
            if(error){
                return done(error)
            } else {
                return done(null, usuario)
            }
            
        })
    })
}