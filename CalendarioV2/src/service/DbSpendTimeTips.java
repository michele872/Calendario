package service;

import javax.persistence.EntityManager;

import model.SpTimeTip;

public class DbSpendTimeTips {
	
	public static SpTimeTip getSpttById (SpTimeTip stt) {
		EntityManager em = DbUtil.getEntityManager("calendario");
		SpTimeTip sptt = em.find(SpTimeTip.class, stt);
		return sptt;
	}
}
