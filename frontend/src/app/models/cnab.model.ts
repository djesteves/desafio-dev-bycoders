class Cnab {
    constructor (
        public id: string,
        public tipo: string,
        public data: Date,
        public valor: string,
        public cpf: string,
        public cartao: string,
        public hora: Date,
        public donoLoja: string,
        public nomeLoja: string
    ) { }

}

export { Cnab }