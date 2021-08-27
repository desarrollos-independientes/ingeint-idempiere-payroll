/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.ingeint.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for HR_Shifts
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_HR_Shifts extends PO implements I_HR_Shifts, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210824L;

    /** Standard Constructor */
    public X_HR_Shifts (Properties ctx, int HR_Shifts_ID, String trxName)
    {
      super (ctx, HR_Shifts_ID, trxName);
      /** if (HR_Shifts_ID == 0)
        {
			setHR_Shifts_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_HR_Shifts (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_HR_Shifts[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Shifts for Employee.
		@param HR_Shifts_ID Shifts for Employee	  */
	public void setHR_Shifts_ID (int HR_Shifts_ID)
	{
		if (HR_Shifts_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_HR_Shifts_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_HR_Shifts_ID, Integer.valueOf(HR_Shifts_ID));
	}

	/** Get Shifts for Employee.
		@return Shifts for Employee	  */
	public int getHR_Shifts_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HR_Shifts_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set ING_Shifts_UU.
		@param HR_Shifts_UU ING_Shifts_UU	  */
	public void setHR_Shifts_UU (String HR_Shifts_UU)
	{
		set_Value (COLUMNNAME_HR_Shifts_UU, HR_Shifts_UU);
	}

	/** Get ING_Shifts_UU.
		@return ING_Shifts_UU	  */
	public String getHR_Shifts_UU () 
	{
		return (String)get_Value(COLUMNNAME_HR_Shifts_UU);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}