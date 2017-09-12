package bdecco.cvc.financialscheduling.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.core.SchendulingTrasnferController;
import bdecco.cvc.financialscheduling.dao.SchendulingTransferDao;
import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;

@RunWith(MockitoJUnitRunner.class)
public class SchendulingTest {

	@InjectMocks
	private  SchendulingTrasnferController schendulingTrasnferController;
	@Mock
	private SchendulingTransferDao sdao;
	
	private SchendulingTransferTO schendulingTransferTO;
	
	@Before
	public void before() {
		schendulingTransferTO = new SchendulingTransferTO();

		LocalDate today = LocalDate.now();
		schendulingTransferTO.setDateAppointment(today);
		schendulingTransferTO.setDestinationAccount("XXX");
		schendulingTransferTO.setSourceAccount("XXXX");

	}
	
	@Test
	public void testDoExecutionCalculateThousand() throws OSSBusinessException {
		LocalDate schedule = LocalDate.now();
		schendulingTransferTO.setDateTransfer(schedule);

		schendulingTransferTO.setValueTransfer(1000);
		schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);
		
		assertNotNull(schendulingTransferTO.getRate());
	}

	@Test
	public void testDoExecutionCalculateTwoThousand() throws OSSBusinessException {
		LocalDate schedule = LocalDate.of(2017, Month.SEPTEMBER, 10);
		schendulingTransferTO.setDateTransfer(schedule);
		schendulingTransferTO.setValueTransfer(2000);
		schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);
		
		assertNotNull(schendulingTransferTO.getRate());
	}

	@Test
	public void testDoExecutionCalculateThreeThousand() throws OSSBusinessException {
		LocalDate schedule = LocalDate.of(2017, Month.SEPTEMBER, 25);
		schendulingTransferTO.setDateTransfer(schedule);

		schendulingTransferTO.setValueTransfer(3000);
		schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);
		
		assertNotNull(schendulingTransferTO.getRate());
	}

	@Test
	public void testDoExecutionFind() throws OSSBusinessException {
		
		
		when(sdao.findSchendulingTransfer(anyObject())).thenReturn(schendulingTransferTO);
		
		SchendulingTransferTO findSchenduling = schendulingTrasnferController.findSchendulingTranfer(schendulingTransferTO.getSourceAccount());
		
		assertNotNull(findSchenduling);
	}
	
	@Test
	public void testDoExecutionNoRateOSSBusinessException(){
		LocalDate schedule = LocalDate.of(2017, Month.SEPTEMBER, 20);
		schendulingTransferTO.setDateTransfer(schedule);
		schendulingTransferTO.setValueTransfer(500);
		
		try {
			schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);
		} catch (OSSBusinessException e) {
			assertTrue("Erro ao calcular ", "Não existe TAXA aplicavel".equalsIgnoreCase(e.getDescription()));
		}

	}

	@Test(expected=NullPointerException.class)
	public void testDoExecutionNullPointer() throws OSSBusinessException {
		
		schendulingTransferTO = null;
		schendulingTrasnferController.calculatesSchedulingTransfer(schendulingTransferTO);

	}
}
