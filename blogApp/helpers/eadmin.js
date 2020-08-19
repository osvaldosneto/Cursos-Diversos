//cladsse que vai nos auxiliar a ver se usuário é admin

module.exports = {
    eadmin: function(req, res, next){
        if(req.session.passport.user !== undefined){ //permite que apenas usuários autenticados entram no sistema
            return next();                                
        } else {
            req.flash("error_msg", "Você deve estar logado para entrar.")
            res.redirect("/")
        }
    }  
}