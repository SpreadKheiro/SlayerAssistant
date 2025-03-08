package com.makingstan;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("slayermaster")
public interface ExampleConfig extends Config
{
	@ConfigItem(
			keyName = "showAvailableTasks",
			name = "Afficher les tâches de Slayer",
			description = "Affiche toutes les tâches disponibles pour chaque Slayer Master"
	)
	default boolean showAvailableTasks()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showMonsterStats",
			name = "Afficher les statistiques des monstres",
			description = "Affiche les faiblesses et forces des monstres directement via le wiki"
	)
	default boolean showMonsterStats()
	{
		return true;
	}

	@ConfigItem(
			keyName = "scanInventory",
			name = "Scanner l'inventaire",
			description = "Analyse votre équipement et suggère les meilleures armes/armures pour chaque monstre"
	)
	default boolean scanInventory()
	{
		return true;
	}
}
