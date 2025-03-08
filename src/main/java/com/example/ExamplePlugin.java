package com.makingstan;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
		name = "Slayer Pro Helper",
		description = "Affiche les tâches Slayer, les stats des monstres et suggère l'équipement",
		tags = {"slayer", "tasks", "monsters", "equipment"}
)
public class ExamplePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ExampleConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ExampleOverlay overlay;

	@Provides
	ExampleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExampleConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		log.info("Slayer Helper démarré !");
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Slayer Helper arrêté !");
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (config.showAvailableTasks())
		{
			log.info("Affichage des tâches Slayer disponibles...");
			// TODO: Ajouter la logique pour afficher les tâches Slayer
		}

		if (config.showMonsterStats())
		{
			log.info("Affichage des statistiques des monstres...");
			// TODO: Ajouter la logique pour afficher les statistiques des monstres
		}

		if (config.scanInventory())
		{
			log.info("Analyse de l'inventaire en cours...");
			// TODO: Ajouter la logique pour scanner l'inventaire et recommander un équipement
		}
	}
}
