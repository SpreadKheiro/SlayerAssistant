package com.makingstan;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.*;
import javax.inject.Inject;
import java.awt.*;

public class ExampleOverlay extends Overlay
{
    private final Client client;
    private final ExampleConfig config;

    @Inject
    public ExampleOverlay(Client client, ExampleConfig config)
    {
        this.client = client;
        this.config = config;
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        int y = 20;

        if (config.showAvailableTasks())
        {
            graphics.setColor(Color.WHITE);
            graphics.drawString("Tâches Slayer Disponibles:", 10, y);
            y += 15;
            // TODO: Ajouter la liste des tâches disponibles
        }

        if (config.showMonsterStats())
        {
            graphics.setColor(Color.YELLOW);
            graphics.drawString("Statistiques des monstres activées", 10, y);
            y += 15;
            // TODO: Afficher les stats du monstre ciblé
        }

        if (config.scanInventory())
        {
            graphics.setColor(Color.GREEN);
            graphics.drawString("Scan de l’inventaire actif", 10, y);
            y += 15;
            // TODO: Afficher la recommandation d’équipement
        }

        return new Dimension(200, y);
    }
}
