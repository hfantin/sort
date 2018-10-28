Comandos do cargo

cargo new nome-projeto -> cria novo projeto 
cargo build -> realiza o build do projeto 
               o executavel sera criado em /target/debug
                --release faz o build da release

cargo run    -> executa o projeto             
                caso o arquivo tenha mudado, executa o build novamente
cargo check  -> verfica se o projeto compilou mas não criou um executavel
                 (é mais rapido que o build por que nao gera o executavel)

cargo update -> atualiza dependencias ignorando o Cargo.lock
cargo doc --open -> gera a documentacao do projeto, incluindo as crates