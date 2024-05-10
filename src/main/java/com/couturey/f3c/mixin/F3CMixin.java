package com.couturey.f3c.mixin;
import com.couturey.f3c.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class F3CMixin {
	@Unique
	private boolean keysPressed = false;

	@Inject(method = "handleInputEvents", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/option/KeyBinding;wasPressed()Z"), cancellable = true)
	public void onHandleInputEvents(CallbackInfo ci) {
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		boolean f3Pressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_F3);
		boolean cPressed = InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_C);

		if (f3Pressed && cPressed && config.modEnabled) {
			if (!keysPressed) {
				int x = (int) Math.round(MinecraftClient.getInstance().player.getX());
				int y = (int) Math.round(MinecraftClient.getInstance().player.getY());
				int z = (int) Math.round(MinecraftClient.getInstance().player.getZ());

				String coordinates = String.format(config.chatOutput, x, y, z);
				GLFW.glfwSetClipboardString(MinecraftClient.getInstance().getWindow().getHandle(), coordinates);

				keysPressed = true;
				ci.cancel();
			}
		} else {
			keysPressed = false;
		}
	}
}
