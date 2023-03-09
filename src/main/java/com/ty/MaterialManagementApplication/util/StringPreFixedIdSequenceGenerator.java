package com.ty.MaterialManagementApplication.util;


import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class StringPreFixedIdSequenceGenerator  extends SequenceStyleGenerator{
	public static final String VALUE_PREFIXE_PARAMETER ="valuePrefix";
	public static final String VALUE_PREFIXE_DEFAULT ="";
	private String valuePrefix;
	
	public static final String NUMBER_FORMAT_PARAMETER="numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT="%d";
	 
	private String numberFormat;

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		// TODO Auto-generated method stub
		super.configure(LongType.INSTANCE,params,serviceRegistry);
		valuePrefix=ConfigurationHelper.getString(VALUE_PREFIXE_PARAMETER, params,VALUE_PREFIXE_DEFAULT);
		numberFormat=ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params,NUMBER_FORMAT_DEFAULT);
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		return valuePrefix+ String.format(numberFormat, super.generate(session, object));
	}
	
	

}