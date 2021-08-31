package dev.itechsolutions.callout;

import java.util.Optional;

import org.eevolution.model.MHRConcept;
import org.eevolution.model.MHRPayrollConcept;

import com.ingeint.base.CustomCallout;

/**
 * 
 * @author Argenis Rodríguez
 *
 */
public class CalloutPayrollConcept extends CustomCallout {
	
	@Override
	protected String start() {
		
		if (isCalloutActive())
			return "";
		
		if (MHRPayrollConcept.COLUMNNAME_HR_Concept_ID.equals(getColumnName()))
		{
			int HR_Concept_ID = Optional.ofNullable((Integer) getValue())
					.orElse(0);
			
			String name = null;
			
			if (HR_Concept_ID > 0)
			{
				MHRConcept concept = new MHRConcept(getCtx(), HR_Concept_ID, null);
				name = concept.getName();
			}
			
			getTab().setValue(MHRPayrollConcept.COLUMNNAME_Name, name);
		}
		
		return "";
	}
}
