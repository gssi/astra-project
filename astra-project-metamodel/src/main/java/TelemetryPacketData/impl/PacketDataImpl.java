/**
 */
package TelemetryPacketData.impl;

import TelemetryPacketData.PacketData;
import TelemetryPacketData.PacketDataPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Packet Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getFrameTime <em>Frame Time</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getObrt <em>Obrt</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getPkt <em>Pkt</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getPktHeader <em>Pkt Header</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getPuslMaxDuration <em>Pusl Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getSatcmMaxDuration <em>Satcm Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getSsmaplMaxDuration <em>Ssmapl Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getSsmapfMaxDuration <em>Ssmapf Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getAocscmPreMaxD <em>Aocscm Pre Max D</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getAocnMaxDuration <em>Aocn Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getAocscmPostMaxDur <em>Aocscm Post Max Dur</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getCmgMxDuration <em>Cmg Mx Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getSfdirMxDuration <em>Sfdir Mx Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getCodMaxDur <em>Cod Max Dur</em>}</li>
 *   <li>{@link TelemetryPacketData.impl.PacketDataImpl#getPodMaxDur <em>Pod Max Dur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PacketDataImpl extends MinimalEObjectImpl.Container implements PacketData {
	/**
	 * The default value of the '{@link #getFrameTime() <em>Frame Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameTime()
	 * @generated
	 * @ordered
	 */
	protected static final String FRAME_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrameTime() <em>Frame Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameTime()
	 * @generated
	 * @ordered
	 */
	protected String frameTime = FRAME_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getObrt() <em>Obrt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObrt()
	 * @generated
	 * @ordered
	 */
	protected static final int OBRT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getObrt() <em>Obrt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObrt()
	 * @generated
	 * @ordered
	 */
	protected int obrt = OBRT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPkt() <em>Pkt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkt()
	 * @generated
	 * @ordered
	 */
	protected static final int PKT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPkt() <em>Pkt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkt()
	 * @generated
	 * @ordered
	 */
	protected int pkt = PKT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPktHeader() <em>Pkt Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPktHeader()
	 * @generated
	 * @ordered
	 */
	protected static final String PKT_HEADER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPktHeader() <em>Pkt Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPktHeader()
	 * @generated
	 * @ordered
	 */
	protected String pktHeader = PKT_HEADER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPuslMaxDuration() <em>Pusl Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPuslMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int PUSL_MAX_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPuslMaxDuration() <em>Pusl Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPuslMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected int puslMaxDuration = PUSL_MAX_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSatcmMaxDuration() <em>Satcm Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatcmMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int SATCM_MAX_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSatcmMaxDuration() <em>Satcm Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatcmMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected int satcmMaxDuration = SATCM_MAX_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSsmaplMaxDuration() <em>Ssmapl Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsmaplMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int SSMAPL_MAX_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSsmaplMaxDuration() <em>Ssmapl Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsmaplMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected int ssmaplMaxDuration = SSMAPL_MAX_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSsmapfMaxDuration() <em>Ssmapf Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsmapfMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int SSMAPF_MAX_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSsmapfMaxDuration() <em>Ssmapf Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsmapfMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected int ssmapfMaxDuration = SSMAPF_MAX_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAocscmPreMaxD() <em>Aocscm Pre Max D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAocscmPreMaxD()
	 * @generated
	 * @ordered
	 */
	protected static final int AOCSCM_PRE_MAX_D_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAocscmPreMaxD() <em>Aocscm Pre Max D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAocscmPreMaxD()
	 * @generated
	 * @ordered
	 */
	protected int aocscmPreMaxD = AOCSCM_PRE_MAX_D_EDEFAULT;

	/**
	 * The default value of the '{@link #getAocnMaxDuration() <em>Aocn Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAocnMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int AOCN_MAX_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAocnMaxDuration() <em>Aocn Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAocnMaxDuration()
	 * @generated
	 * @ordered
	 */
	protected int aocnMaxDuration = AOCN_MAX_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAocscmPostMaxDur() <em>Aocscm Post Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAocscmPostMaxDur()
	 * @generated
	 * @ordered
	 */
	protected static final int AOCSCM_POST_MAX_DUR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAocscmPostMaxDur() <em>Aocscm Post Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAocscmPostMaxDur()
	 * @generated
	 * @ordered
	 */
	protected int aocscmPostMaxDur = AOCSCM_POST_MAX_DUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCmgMxDuration() <em>Cmg Mx Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmgMxDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int CMG_MX_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCmgMxDuration() <em>Cmg Mx Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmgMxDuration()
	 * @generated
	 * @ordered
	 */
	protected int cmgMxDuration = CMG_MX_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSfdirMxDuration() <em>Sfdir Mx Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSfdirMxDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int SFDIR_MX_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSfdirMxDuration() <em>Sfdir Mx Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSfdirMxDuration()
	 * @generated
	 * @ordered
	 */
	protected int sfdirMxDuration = SFDIR_MX_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCodMaxDur() <em>Cod Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodMaxDur()
	 * @generated
	 * @ordered
	 */
	protected static final int COD_MAX_DUR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCodMaxDur() <em>Cod Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodMaxDur()
	 * @generated
	 * @ordered
	 */
	protected int codMaxDur = COD_MAX_DUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getPodMaxDur() <em>Pod Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPodMaxDur()
	 * @generated
	 * @ordered
	 */
	protected static final int POD_MAX_DUR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPodMaxDur() <em>Pod Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPodMaxDur()
	 * @generated
	 * @ordered
	 */
	protected int podMaxDur = POD_MAX_DUR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PacketDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PacketDataPackage.Literals.PACKET_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFrameTime() {
		return frameTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrameTime(String newFrameTime) {
		String oldFrameTime = frameTime;
		frameTime = newFrameTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__FRAME_TIME, oldFrameTime, frameTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getObrt() {
		return obrt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObrt(int newObrt) {
		int oldObrt = obrt;
		obrt = newObrt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__OBRT, oldObrt, obrt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPkt() {
		return pkt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPkt(int newPkt) {
		int oldPkt = pkt;
		pkt = newPkt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__PKT, oldPkt, pkt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPktHeader() {
		return pktHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPktHeader(String newPktHeader) {
		String oldPktHeader = pktHeader;
		pktHeader = newPktHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__PKT_HEADER, oldPktHeader, pktHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPuslMaxDuration() {
		return puslMaxDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPuslMaxDuration(int newPuslMaxDuration) {
		int oldPuslMaxDuration = puslMaxDuration;
		puslMaxDuration = newPuslMaxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__PUSL_MAX_DURATION, oldPuslMaxDuration, puslMaxDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSatcmMaxDuration() {
		return satcmMaxDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSatcmMaxDuration(int newSatcmMaxDuration) {
		int oldSatcmMaxDuration = satcmMaxDuration;
		satcmMaxDuration = newSatcmMaxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__SATCM_MAX_DURATION, oldSatcmMaxDuration, satcmMaxDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSsmaplMaxDuration() {
		return ssmaplMaxDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSsmaplMaxDuration(int newSsmaplMaxDuration) {
		int oldSsmaplMaxDuration = ssmaplMaxDuration;
		ssmaplMaxDuration = newSsmaplMaxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__SSMAPL_MAX_DURATION, oldSsmaplMaxDuration, ssmaplMaxDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSsmapfMaxDuration() {
		return ssmapfMaxDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSsmapfMaxDuration(int newSsmapfMaxDuration) {
		int oldSsmapfMaxDuration = ssmapfMaxDuration;
		ssmapfMaxDuration = newSsmapfMaxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__SSMAPF_MAX_DURATION, oldSsmapfMaxDuration, ssmapfMaxDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAocscmPreMaxD() {
		return aocscmPreMaxD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAocscmPreMaxD(int newAocscmPreMaxD) {
		int oldAocscmPreMaxD = aocscmPreMaxD;
		aocscmPreMaxD = newAocscmPreMaxD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__AOCSCM_PRE_MAX_D, oldAocscmPreMaxD, aocscmPreMaxD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAocnMaxDuration() {
		return aocnMaxDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAocnMaxDuration(int newAocnMaxDuration) {
		int oldAocnMaxDuration = aocnMaxDuration;
		aocnMaxDuration = newAocnMaxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__AOCN_MAX_DURATION, oldAocnMaxDuration, aocnMaxDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getAocscmPostMaxDur() {
		return aocscmPostMaxDur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAocscmPostMaxDur(int newAocscmPostMaxDur) {
		int oldAocscmPostMaxDur = aocscmPostMaxDur;
		aocscmPostMaxDur = newAocscmPostMaxDur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__AOCSCM_POST_MAX_DUR, oldAocscmPostMaxDur, aocscmPostMaxDur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCmgMxDuration() {
		return cmgMxDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCmgMxDuration(int newCmgMxDuration) {
		int oldCmgMxDuration = cmgMxDuration;
		cmgMxDuration = newCmgMxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__CMG_MX_DURATION, oldCmgMxDuration, cmgMxDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSfdirMxDuration() {
		return sfdirMxDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSfdirMxDuration(int newSfdirMxDuration) {
		int oldSfdirMxDuration = sfdirMxDuration;
		sfdirMxDuration = newSfdirMxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__SFDIR_MX_DURATION, oldSfdirMxDuration, sfdirMxDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCodMaxDur() {
		return codMaxDur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodMaxDur(int newCodMaxDur) {
		int oldCodMaxDur = codMaxDur;
		codMaxDur = newCodMaxDur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__COD_MAX_DUR, oldCodMaxDur, codMaxDur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPodMaxDur() {
		return podMaxDur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPodMaxDur(int newPodMaxDur) {
		int oldPodMaxDur = podMaxDur;
		podMaxDur = newPodMaxDur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PacketDataPackage.PACKET_DATA__POD_MAX_DUR, oldPodMaxDur, podMaxDur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PacketDataPackage.PACKET_DATA__FRAME_TIME:
				return getFrameTime();
			case PacketDataPackage.PACKET_DATA__OBRT:
				return getObrt();
			case PacketDataPackage.PACKET_DATA__PKT:
				return getPkt();
			case PacketDataPackage.PACKET_DATA__PKT_HEADER:
				return getPktHeader();
			case PacketDataPackage.PACKET_DATA__PUSL_MAX_DURATION:
				return getPuslMaxDuration();
			case PacketDataPackage.PACKET_DATA__SATCM_MAX_DURATION:
				return getSatcmMaxDuration();
			case PacketDataPackage.PACKET_DATA__SSMAPL_MAX_DURATION:
				return getSsmaplMaxDuration();
			case PacketDataPackage.PACKET_DATA__SSMAPF_MAX_DURATION:
				return getSsmapfMaxDuration();
			case PacketDataPackage.PACKET_DATA__AOCSCM_PRE_MAX_D:
				return getAocscmPreMaxD();
			case PacketDataPackage.PACKET_DATA__AOCN_MAX_DURATION:
				return getAocnMaxDuration();
			case PacketDataPackage.PACKET_DATA__AOCSCM_POST_MAX_DUR:
				return getAocscmPostMaxDur();
			case PacketDataPackage.PACKET_DATA__CMG_MX_DURATION:
				return getCmgMxDuration();
			case PacketDataPackage.PACKET_DATA__SFDIR_MX_DURATION:
				return getSfdirMxDuration();
			case PacketDataPackage.PACKET_DATA__COD_MAX_DUR:
				return getCodMaxDur();
			case PacketDataPackage.PACKET_DATA__POD_MAX_DUR:
				return getPodMaxDur();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PacketDataPackage.PACKET_DATA__FRAME_TIME:
				setFrameTime((String)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__OBRT:
				setObrt((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__PKT:
				setPkt((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__PKT_HEADER:
				setPktHeader((String)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__PUSL_MAX_DURATION:
				setPuslMaxDuration((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__SATCM_MAX_DURATION:
				setSatcmMaxDuration((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__SSMAPL_MAX_DURATION:
				setSsmaplMaxDuration((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__SSMAPF_MAX_DURATION:
				setSsmapfMaxDuration((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__AOCSCM_PRE_MAX_D:
				setAocscmPreMaxD((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__AOCN_MAX_DURATION:
				setAocnMaxDuration((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__AOCSCM_POST_MAX_DUR:
				setAocscmPostMaxDur((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__CMG_MX_DURATION:
				setCmgMxDuration((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__SFDIR_MX_DURATION:
				setSfdirMxDuration((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__COD_MAX_DUR:
				setCodMaxDur((Integer)newValue);
				return;
			case PacketDataPackage.PACKET_DATA__POD_MAX_DUR:
				setPodMaxDur((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PacketDataPackage.PACKET_DATA__FRAME_TIME:
				setFrameTime(FRAME_TIME_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__OBRT:
				setObrt(OBRT_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__PKT:
				setPkt(PKT_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__PKT_HEADER:
				setPktHeader(PKT_HEADER_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__PUSL_MAX_DURATION:
				setPuslMaxDuration(PUSL_MAX_DURATION_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__SATCM_MAX_DURATION:
				setSatcmMaxDuration(SATCM_MAX_DURATION_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__SSMAPL_MAX_DURATION:
				setSsmaplMaxDuration(SSMAPL_MAX_DURATION_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__SSMAPF_MAX_DURATION:
				setSsmapfMaxDuration(SSMAPF_MAX_DURATION_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__AOCSCM_PRE_MAX_D:
				setAocscmPreMaxD(AOCSCM_PRE_MAX_D_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__AOCN_MAX_DURATION:
				setAocnMaxDuration(AOCN_MAX_DURATION_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__AOCSCM_POST_MAX_DUR:
				setAocscmPostMaxDur(AOCSCM_POST_MAX_DUR_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__CMG_MX_DURATION:
				setCmgMxDuration(CMG_MX_DURATION_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__SFDIR_MX_DURATION:
				setSfdirMxDuration(SFDIR_MX_DURATION_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__COD_MAX_DUR:
				setCodMaxDur(COD_MAX_DUR_EDEFAULT);
				return;
			case PacketDataPackage.PACKET_DATA__POD_MAX_DUR:
				setPodMaxDur(POD_MAX_DUR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PacketDataPackage.PACKET_DATA__FRAME_TIME:
				return FRAME_TIME_EDEFAULT == null ? frameTime != null : !FRAME_TIME_EDEFAULT.equals(frameTime);
			case PacketDataPackage.PACKET_DATA__OBRT:
				return obrt != OBRT_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__PKT:
				return pkt != PKT_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__PKT_HEADER:
				return PKT_HEADER_EDEFAULT == null ? pktHeader != null : !PKT_HEADER_EDEFAULT.equals(pktHeader);
			case PacketDataPackage.PACKET_DATA__PUSL_MAX_DURATION:
				return puslMaxDuration != PUSL_MAX_DURATION_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__SATCM_MAX_DURATION:
				return satcmMaxDuration != SATCM_MAX_DURATION_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__SSMAPL_MAX_DURATION:
				return ssmaplMaxDuration != SSMAPL_MAX_DURATION_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__SSMAPF_MAX_DURATION:
				return ssmapfMaxDuration != SSMAPF_MAX_DURATION_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__AOCSCM_PRE_MAX_D:
				return aocscmPreMaxD != AOCSCM_PRE_MAX_D_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__AOCN_MAX_DURATION:
				return aocnMaxDuration != AOCN_MAX_DURATION_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__AOCSCM_POST_MAX_DUR:
				return aocscmPostMaxDur != AOCSCM_POST_MAX_DUR_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__CMG_MX_DURATION:
				return cmgMxDuration != CMG_MX_DURATION_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__SFDIR_MX_DURATION:
				return sfdirMxDuration != SFDIR_MX_DURATION_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__COD_MAX_DUR:
				return codMaxDur != COD_MAX_DUR_EDEFAULT;
			case PacketDataPackage.PACKET_DATA__POD_MAX_DUR:
				return podMaxDur != POD_MAX_DUR_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (frameTime: ");
		result.append(frameTime);
		result.append(", obrt: ");
		result.append(obrt);
		result.append(", pkt: ");
		result.append(pkt);
		result.append(", pktHeader: ");
		result.append(pktHeader);
		result.append(", puslMaxDuration: ");
		result.append(puslMaxDuration);
		result.append(", satcmMaxDuration: ");
		result.append(satcmMaxDuration);
		result.append(", ssmaplMaxDuration: ");
		result.append(ssmaplMaxDuration);
		result.append(", ssmapfMaxDuration: ");
		result.append(ssmapfMaxDuration);
		result.append(", aocscmPreMaxD: ");
		result.append(aocscmPreMaxD);
		result.append(", aocnMaxDuration: ");
		result.append(aocnMaxDuration);
		result.append(", aocscmPostMaxDur: ");
		result.append(aocscmPostMaxDur);
		result.append(", cmgMxDuration: ");
		result.append(cmgMxDuration);
		result.append(", sfdirMxDuration: ");
		result.append(sfdirMxDuration);
		result.append(", codMaxDur: ");
		result.append(codMaxDur);
		result.append(", podMaxDur: ");
		result.append(podMaxDur);
		result.append(')');
		return result.toString();
	}

} //PacketDataImpl
