package net.luis.survive.core;

import java.util.Optional;

import net.luis.survive.core.message.backpack.BackpackDownToolMessage;
import net.luis.survive.core.message.backpack.BackpackNextDownToolMessage;
import net.luis.survive.core.message.backpack.BackpackNextToolMessage;
import net.luis.survive.core.message.backpack.BackpackNextTopToolMessage;
import net.luis.survive.core.message.backpack.BackpackOpenMessage;
import net.luis.survive.core.message.backpack.BackpackTopToolMessage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModPacketHandler {

	private static final String version = "1";
	private static int id = 0;
	public static SimpleChannel simpleChannel;
	
	public static void init() {
		
		simpleChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation("survive:simple_chnanel"), () -> version,  version::equals, version::equals);
	
		simpleChannel.registerMessage(id++, BackpackOpenMessage.class, BackpackOpenMessage::encode,
				BackpackOpenMessage::decode, BackpackOpenMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackNextToolMessage.class, BackpackNextToolMessage::encode,
				BackpackNextToolMessage::decode, BackpackNextToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackTopToolMessage.class, BackpackTopToolMessage::encode,
				BackpackTopToolMessage::decode, BackpackTopToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackDownToolMessage.class, BackpackDownToolMessage::encode,
				BackpackDownToolMessage::decode, BackpackDownToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackNextDownToolMessage.class, BackpackNextDownToolMessage::encode,
				BackpackNextDownToolMessage::decode, BackpackNextDownToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackNextTopToolMessage.class, BackpackNextTopToolMessage::encode,
				BackpackNextTopToolMessage::decode, BackpackNextTopToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		
	}
	
}
