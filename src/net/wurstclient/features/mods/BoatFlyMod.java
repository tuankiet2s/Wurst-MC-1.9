/*
 * Copyright � 2016 | Alexander01998 | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.wurstclient.features.mods;

import net.wurstclient.compatibility.WMinecraft;
import net.wurstclient.events.listeners.UpdateListener;
import net.wurstclient.features.mods.Mod.Bypasses;

@Mod.Info(category = Mod.Category.MOVEMENT,
	description = "Allows you to fly with boats and rideable entities.\n"
		+ "Bypasses NoCheat+, at least for now.",
	name = "BoatFly",
	tags = "BoatFlight, boat fly, boat flight",
	help = "Mods/BoatFly")
@Bypasses(ghostMode = false, latestNCP = false)
public class BoatFlyMod extends Mod implements UpdateListener
{
	@Override
	public void onEnable()
	{
		wurst.events.add(UpdateListener.class, this);
	}
	
	@Override
	public void onUpdate()
	{
		if(!WMinecraft.getPlayer().isRiding())
			return;
		
		WMinecraft.getPlayer().getRidingEntity().motionY =
			mc.gameSettings.keyBindJump.pressed ? 0.3 : 0;
	}
	
	@Override
	public void onDisable()
	{
		wurst.events.remove(UpdateListener.class, this);
	}
}
