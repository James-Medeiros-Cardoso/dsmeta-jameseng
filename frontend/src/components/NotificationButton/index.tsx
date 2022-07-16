import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type props = {
    saleId: number;
}

function handClick(id: number) {
    axios(`${BASE_URL}/sales/${id}/notification`)
        .then(response => {
            //console.log("SUCESSO!");
            toast.info("SMS Enviado com sucesso.")
        });
}

function NotificationButton({ saleId }: props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton;