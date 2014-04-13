package at.pavlov.cannons.Enum;

public enum MessageEnum
{
	//Error Messages
    ErrorFiringInProgress ("Error.FiringInProgress"),
	ErrorBarrelTooHot ("Error.BarrelTooHot"),
    ErrorNotCleaned ("Error.NotCleaned"),
	ErrorNoGunpowder ("Error.NoGunpowder"),
    ErrorNoProjectile ("Error.NoProjectile"),
    ErrorNotPushed ("Error.NotPushed"),
	ErrorNoFlintAndSteel ("Error.NoFlintAndSteel"),
	ErrorMaximumGunpowderLoaded ("Error.MaximumGunpowderLoaded"),
	ErrorProjectileAlreadyLoaded ("Error.ProjectileAlreadyLoaded"),
	ErrorCannonBuiltLimit ("Error.CannonBuiltLimit"),
	ErrorNotTheOwner ("Error.NotTheOwner"),
    ErrorMissingSign ("Error.MissingSign"),
	
	//Aiming
	SettingCombinedAngle ("Aiming.SettingCombinedAngle"),
	SettingVerticalAngleUp ("Aiming.SettingVerticalAngleUp"),
	SettingVerticalAngleDown ("Aiming.SettingVerticalAngleDown"),
	SettingHorizontalAngleRight ("Aiming.SettingHorizontalAngleRight"),
	SettingHorizontalAngleLeft ("Aiming.SettingHorizontalAngleLeft"),
	AimingModeEnabled ("Aiming.EnableAimingMode"),
	AimingModeDisabled ("Aiming.DisableAimingMode"),
    AimingModeTooFarAway ("Aiming.TooFarForAimingMode"),
	
	//load
	loadProjectile ("Load.Projectile"),
	loadGunpowder ("Load.Gunpowder"),
	
	//cannon
	CannonCreated ("Cannon.Created"),
	CannonDestroyed ("Cannon.Destroyed"),
    CannonsReseted ("Cannon.Reseted"),
	CannonFire ("Cannon.Fire"),

    //projectile
    ProjectileExplosion ("Projectile.Explosion"),
    ProjectileCanceled ("Projectile.Canceled"),

    //heatManagement
    HeatManagementBurn ("HeatManagement.Burn"),
    HeatManagementCooling ("HeatManagement.Cooling"),
    HeatManagementInfo ("HeatManagement.Info"),
    HeatManagementCritical ("HeatManagement.Critical"),
    HeatManagementOverheated ("HeatManagement.Overheated"),

    //ramrod
    RamrodCleaning ("Ramrod.Cleaning"),
    RamrodCleaningDone ("Ramrod.CleaningDone"),
    RamrodPushingProjectile ("Ramrod.PushingProjectile"),
    RamrodPushingProjectileDone ("Ramrod.PushingProjectileDone"),

    //imitatedEffects
    ImitatedEffectsEnabled ("ImitatedEffects.Enabled"),
    ImitatedEffectsDisabled ("ImitatedEffects.Disabled"),
	
	//Permission
	PermissionErrorRedstone ("Permission.ErrorRedstone"),
	PermissionErrorBuild ("Permission.ErrorBuild"),
	PermissionErrorFire ("Permission.ErrorFire"),
	PermissionErrorLoad ("Permission.ErrorLoad"),
	PermissionErrorAdjust ("Permission.ErrorAdjust"),
	PermissionErrorProjectile ("Permission.ErrorProjectile"),
    PermissionErrorThermometer ("Permission.ErrorThermometer"),
    PermissionErrorRamrod ("Permission.ErrorRamrod"),
	
	//Help
	HelpText ("Help.Text"),
	HelpBuild ("Help.Build"),
    HelpFire ("Help.Fire"),
	HelpAdjust ("Help.Adjust");

	
	private final String str;
	
	MessageEnum(String str)
	{
		this.str = str;
	}

	public String getString()
	{
		return str;
	}
}
