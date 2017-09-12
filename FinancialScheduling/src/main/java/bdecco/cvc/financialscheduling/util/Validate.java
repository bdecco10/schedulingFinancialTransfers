package bdecco.cvc.financialscheduling.util;

import java.time.Period;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;

public abstract class Validate {

	/**
	 * Metodo responsavel por validar 
	 * Operações do tipo C tem uma taxa regressiva conforme a data de
	 * transferência 
	 * @return
	 * @throws OSSBusinessException
	 */
	public boolean validateTackwardAX(SchendulingTransferTO entity) throws OSSBusinessException {
		Period period = Period.between(entity.getDateAppointment(),entity.getDateTransfer() );

		if(period.getMonths()== 0 && period.getDays() > 10 && period.getDays()  <= 20){
			//acima de 10 dias da data de agendamento 8.2%
			return true;

		}else if(period.getMonths()== 0 && period.getDays()  > 20 && period.getDays()  <= 30){
			//acima de 20 dias da data de agendamento 6.9% 
			return true;

		}else if(period.getDays() > 30 && period.getMonths() == 0){
			//acima de 30 dias da data de agendamento 4.7% 
			return true;
			//period.getDays() > 40
		}else if(period.getMonths() >= 1 && period.getDays() > 10){
			//acima de 40 dias da data de agendamento-1.7% 
			return true;
		}
		return false;
	}
	/**
	 * Metodo responsavel por validar 
	 * Tranferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a
	 * ser transferido 
	 * @return
	 * @throws OSSBusinessException
	 */
	public boolean transferDay(SchendulingTransferTO entity) throws OSSBusinessException {
		Period period = Period.between(entity.getDateAppointment(), entity.getDateTransfer());
		if(0 == period.getDays()){
			return true;
		}
		return false;
	}

	/**
	 * Metodo responsavel por validar 
	 * Tranferências até 10 dias da data de agendamento possuem uma taxa de $12
	 * @return
	 * @throws OSSBusinessException
	 */
	public boolean validateTransferUpToDays(SchendulingTransferTO entity) throws OSSBusinessException {
		Period period = Period.between(entity.getDateAppointment(), entity.getDateTransfer());
		if(period.getMonths()== 0 && period.getDays()<= 10){
			return true;
		}
		return false;
	}

	/**
	 * Metodo responsavel por validar 
 	 * Valores até $1.000 seguem a taxação tipo A 
	 * @return
	 * @throws OSSBusinessException
	 */
	public boolean transferValueMoreThousand(SchendulingTransferTO entity) throws OSSBusinessException {
		if(entity.getValueTransfer() <= 1000){
			return true;
		}
		return false;
	}
	/**
	 * Metodo responsavel por validar 
	 * Valores de $1.001 até $2.000 seguem a taxação tipo B  
	 * @return
	 * @throws OSSBusinessException
	 */
	public boolean transferValueTwoThousand(SchendulingTransferTO entity) throws OSSBusinessException {
		if(entity.getValueTransfer() >= 1001 && entity.getValueTransfer() <= 2000){
			return true;
		}
		return false;
	}

	/**
	 * Metodo responsavel por validar 
	 * Valores maiores que $2.000 seguem a taxação tipo C 
	 * @return
	 * @throws OSSBusinessException
	 */
	public boolean transferValueMoreTwoThousand(SchendulingTransferTO entity) throws OSSBusinessException {
		if(entity.getValueTransfer() > 2000){
			return true;
		}
		return false;
	}

	/**
	 * Metodo responsavel por validar 
	 * Calcula taxação tipo C 
	 * @return
	 * @throws OSSBusinessException
	 */
	public double tackwardAX(SchendulingTransferTO entity) throws OSSBusinessException {
		Period period = Period.between(entity.getDateAppointment(), entity.getDateTransfer());
		double result = 0;

		if(period.getMonths()== 0 && period.getDays() > 10 && period.getDays()  <= 20){
			//acima de 10 dias da data de agendamento 8.2%
			result = (entity.getValueTransfer() * 8.2)/100;

		}else if(period.getMonths()== 0 && period.getDays()  > 20 && period.getDays()  <= 30){
			//acima de 20 dias da data de agendamento 6.9% 
			result = (entity.getValueTransfer() * 6.9)/100;

		}else if(period.getDays() > 30 && period.getMonths() == 0){
			//acima de 30 dias da data de agendamento 4.7% 
			result = (entity.getValueTransfer() * 4.7)/100;

		}else if(period.getMonths() >= 1 && period.getDays() > 10){
			//acima de 40 dias da data de agendamento-1.7% 
			result = (entity.getValueTransfer() * 1.7)/100;
		}

		return result;
	}

	/**
	 * Metodo responsavel por validar 
	 * Calcula taxação tipo A 
	 * @return
	 * @throws OSSBusinessException
	 */
	public double transferToday(SchendulingTransferTO entity) throws OSSBusinessException {
		double value = entity.getValueTransfer() + 3;
		double result = (value * 0.3)/100;

		return result;
	}
	/**
	 * Metodo responsavel por validar 
	 * Calcula taxação tipo B 
	 * @return
	 * @throws OSSBusinessException
	 */
	public double transferUpToDays(SchendulingTransferTO entity) throws OSSBusinessException {

		double result = entity.getValueTransfer() + 12;

		return result;
	}
}
