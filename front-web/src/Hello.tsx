import { useEffect } from "react";


type Props = {
    message : string;
}

function Hello({message} : Props){
    // chamada para API para buscar os produtos
    useEffect(() => {
        console.log('componente iniciou');
    }, []);

    return (
        <h1>Hello {message}!</h1>
    )
}

export default Hello;