package li.cil.oc.client

import li.cil.oc.Settings
import li.cil.oc.common.Slot
import li.cil.oc.common.Tier
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.texture.TextureMap
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.TextureStitchEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

import scala.collection.mutable

object Textures {

  object Font extends TextureBundle {
    val Aliased = L("chars_aliased")
    val AntiAliased = L("chars.png")

    override protected def basePath = "textures/font/%s.png"

    override protected def loader(map: TextureMap, loc: ResourceLocation) = textureManager.bindTexture(loc)
  }

  object GUI extends TextureBundle {
    val Background = L("background")
    val Bar = L("bar")
    val Borders = L("borders")
    val ButtonPower = L("button_power")
    val ButtonRange = L("button_range")
    val ButtonRun = L("button_run")
    val ButtonScroll = L("button_scroll")
    val ButtonSide = L("button_side")
    val ButtonSwitch = L("button_switch")
    val Computer = L("computer")
    val Database = L("database")
    val Database1 = L("database1")
    val Database2 = L("database2")
    val Disassembler = L("disassembler")
    val Drone = L("drone")
    val KeyboardMissing = L("keyboard_missing")
    val Raid = L("raid")
    val Range = L("range")
    val Robot = L("robot")
    val RobotAssembler = L("robot_assembler")
    val RobotNoScreen = L("robot_noscreen")
    val RobotSelection = L("robot_selection")
    val Server = L("server")
    val Slot = L("slot")

    override protected def basePath = "textures/gui/%s.png"

    override protected def loader(map: TextureMap, loc: ResourceLocation) = textureManager.bindTexture(loc)
  }

  object Icons extends TextureBundle {
    private val ForSlotType = Slot.All.map(name => name -> L(name)).toMap
    private val ForTier = Map(Tier.None -> L("na")) ++ (Tier.One to Tier.Three).map(tier => tier -> L("tier" + tier)).toMap

    def get(slotType: String) = ForSlotType.get(slotType).orNull

    def get(tier: Int) = ForTier.get(tier).orNull

    override protected def basePath = "textures/icons/%s.png"

    override protected def loader(map: TextureMap, loc: ResourceLocation) = textureManager.bindTexture(loc)
  }

  object Model extends TextureBundle {
    val HologramEffect = L("HologramEffect")
    val Robot = L("robot")
    val UpgradeCrafting = L("UpgradeCrafting")
    val UpgradeGenerator = L("UpgradeGenerator")
    val UpgradeInventory = L("UpgradeInventory")

    override protected def basePath = "textures/model/%s.png"

    override protected def loader(map: TextureMap, loc: ResourceLocation) = textureManager.bindTexture(loc)
  }

  // These are kept in the block texture atlas to support animations.
  object Block extends TextureBundle {
    val AssemblerSideAssembling = L("AssemblerSideAssembling")
    val AssemblerSideOn = L("AssemblerSideOn")
    val AssemblerTopOn = L("AssemblerTopOn")
    val CableCap = L("CableCap")
    val CaseFrontActivity = L("CaseFrontActivity")
    val CaseFrontOn = L("CaseFrontOn")
    val ChargerFrontOn = L("ChargerFrontOn")
    val ChargerSideOn = L("ChargerSideOn")
    val DisassemblerSideOn = L("DisassemblerSideOn")
    val DisassemblerTopOn = L("DisassemblerTopOn")
    val DiskDriveFrontActivity = L("DiskDriveFrontActivity")
    val GeolyzerTopOn = L("GeolyzerTopOn")
    val MicrocontrollerFrontLight = L("MicrocontrollerFrontLight")
    val MicrocontrollerFrontOn = L("MicrocontrollerFrontOn")
    val PowerDistributorSideOn = L("PowerDistributorSideOn")
    val PowerDistributorTopOn = L("PowerDistributorTopOn")
    val RackFrontActivity = L("ServerRackFrontActivity")
    val RackFrontOn = L("ServerRackFrontOn")
    val RaidFrontActivity = L("RaidFrontActivity")
    val RaidFrontError = L("RaidFrontError")
    val ScreenUpIndicator = L("screen/up_indicator")
    val SwitchSideOn = L("SwitchSideOn")

    // Kill me now.
    object Screen {
      val Single = Array(
        L("screen/b"),
        L("screen/b"),
        L("screen/b2"),
        L("screen/b2"),
        L("screen/b2"),
        L("screen/b2")
      )

      val SingleFront = Array(
        L("screen/f"),
        L("screen/f2")
      )

      val Horizontal = Array(
        // Vertical.
        Array(
          Array(
            L("screen/bht"),
            L("screen/bht"),
            L("screen/bht2"),
            L("screen/bht2"),
            L("screen/b2"),
            L("screen/b2") // Never rendered.
          ),
          Array(
            L("screen/bhm"),
            L("screen/bhm"),
            L("screen/bhm2"),
            L("screen/bhm2"),
            L("screen/b2"), // Never rendered.
            L("screen/b2") // Never rendered.
          ),
          Array(
            L("screen/bhb"),
            L("screen/bhb"),
            L("screen/bhb2"),
            L("screen/bhb2"),
            L("screen/b2"), // Never rendered.
            L("screen/b2")
          )
        ),
        // Horizontal.
        Array(
          Array(
            L("screen/bht2"),
            L("screen/bht2"),
            L("screen/bht"),
            L("screen/bht"),
            L("screen/b2"),
            L("screen/b2") // Never rendered.
          ),
          Array(
            L("screen/bhm2"),
            L("screen/bhm2"),
            L("screen/bhm"),
            L("screen/bhm"),
            L("screen/b2"), // Never rendered.
            L("screen/b2") // Never rendered.
          ),
          Array(
            L("screen/bhb2"),
            L("screen/bhb2"),
            L("screen/bhb"),
            L("screen/bhb"),
            L("screen/b2"), // Never rendered.
            L("screen/b2")
          )
        )
      )

      val HorizontalFront = Array(
        // Vertical.
        Array(
          L("screen/fht2"),
          L("screen/fhm2"),
          L("screen/fhb2")
        ),
        // Horizontal.
        Array(
          L("screen/fht"),
          L("screen/fhm"),
          L("screen/fhb")
        )
      )

      val Vertical = Array(
        // Vertical.
        Array(
          Array(
            L("screen/b"), // Never rendered.
            L("screen/b"),
            L("screen/bvt"),
            L("screen/bvt"),
            L("screen/bvt"),
            L("screen/bvt")
          ),
          Array(
            L("screen/b"), // Never rendered.
            L("screen/b"), // Never rendered.
            L("screen/bvm"),
            L("screen/bvm"),
            L("screen/bvm"),
            L("screen/bvm")
          ),
          Array(
            L("screen/b"),
            L("screen/b"), // Never rendered.
            L("screen/bvb2"),
            L("screen/bvb2"),
            L("screen/bvb2"),
            L("screen/bvb2")
          )
        ),
        // Horizontal.
        Array(
          Array(
            L("screen/b2"), // Never rendered.
            L("screen/b2"),
            L("screen/bvt"),
            L("screen/bvt"),
            L("screen/bht2"),
            L("screen/bht2")
          ),
          Array(
            L("screen/b2"), // Never rendered.
            L("screen/b2"), // Never rendered.
            L("screen/bvm"),
            L("screen/bvm"),
            L("screen/bhm2"),
            L("screen/bhm2")
          ),
          Array(
            L("screen/b2"),
            L("screen/b2"), // Never rendered.
            L("screen/bvb"),
            L("screen/bvb"),
            L("screen/bhb2"),
            L("screen/bhb2")
          )
        )
      )

      val VerticalFront = Array(
        // Vertical.
        Array(
          L("screen/fvt"),
          L("screen/fvm"),
          L("screen/fvb2")
        ),
        // Horizontal.
        Array(
          L("screen/fvt"),
          L("screen/fvm"),
          L("screen/fvb")
        )
      )

      val Multi = Array(
        // Vertical.
        Array(
          // Top.
          Array(
            Array(
              L("screen/bht"), // Never rendered.
              L("screen/bht"),
              L("screen/btl"),
              L("screen/btl"),
              L("screen/bvt"),
              L("screen/bvt") // Never rendered.
            ),Array(
              L("screen/bhm"), // Never rendered.
              L("screen/bhm"),
              L("screen/btm"),
              L("screen/btm"),
              L("screen/bvt"),
              L("screen/bvt") // Never rendered.
            ),
            Array(
              L("screen/bhb"), // Never rendered.
              L("screen/bhb"), // Never rendered.
              L("screen/btr"),
              L("screen/btr"),
              L("screen/bvt"),  // Never rendered.
              L("screen/bvt") // Never rendered.
            )
          ),
          // Middle.
          Array(
            Array(
              L("screen/bht"), // Never rendered.
              L("screen/bht"), // Never rendered.
              L("screen/bml"),
              L("screen/bml"),
              L("screen/bvm"), // Never rendered.
              L("screen/bvm") // Never rendered.
            ),
            Array(
              L("screen/bhm"), // Never rendered.
              L("screen/bhm"), // Never rendered.
              L("screen/bmm"),
              L("screen/bmm"),
              L("screen/bvt"), // Never rendered.
              L("screen/bvt") // Never rendered.
            ),
            Array(
              L("screen/bhb"),
              L("screen/bhb"), // Never rendered.
              L("screen/bmr"),
              L("screen/bmr"),
              L("screen/bvm"),  // Never rendered.
              L("screen/bvm")
            )
          ),
          // Right.
          Array(
            Array(
              L("screen/bht"), // Never rendered.
              L("screen/bht"),
              L("screen/bbl2"),
              L("screen/bbl2"),
              L("screen/bvb2"),
              L("screen/bvb2") // Never rendered.
            ),
            Array(
              L("screen/bhm"),
              L("screen/bhm"), // Never rendered.
              L("screen/bbm2"),
              L("screen/bbm2"),
              L("screen/bvb2"),
              L("screen/bvb2") // Never rendered.
            ),
            Array(
              L("screen/bhb"),
              L("screen/bhb"), // Never rendered.
              L("screen/bbr2"),
              L("screen/bbr2"),
              L("screen/bvb2"),  // Never rendered.
              L("screen/bvb2")
            )
          )
        ),
        // Horizontal.
        Array(
          // Top.
          Array(
            Array(
              L("screen/bht2"), // Never rendered.
              L("screen/bht2"),
              L("screen/btl"),
              L("screen/btl"),
              L("screen/bht2"),
              L("screen/bht2") // Never rendered.
            ),Array(
              L("screen/bhm2"), // Never rendered.
              L("screen/bhm2"),
              L("screen/btm"),
              L("screen/btm"),
              L("screen/bht2"),
              L("screen/bht2") // Never rendered.
            ),
            Array(
              L("screen/bhb2"), // Never rendered.
              L("screen/bhb2"), // Never rendered.
              L("screen/btr"),
              L("screen/btr"),
              L("screen/bht2"),  // Never rendered.
              L("screen/bht2") // Never rendered.
            )
          ),
          // Middle.
          Array(
            Array(
              L("screen/bht2"), // Never rendered.
              L("screen/bht2"), // Never rendered.
              L("screen/bml"),
              L("screen/bml"),
              L("screen/bhm2"), // Never rendered.
              L("screen/bhm2") // Never rendered.
            ),
            Array(
              L("screen/bhm2"), // Never rendered.
              L("screen/bhm2"), // Never rendered.
              L("screen/bmm"),
              L("screen/bmm"),
              L("screen/bht2"), // Never rendered.
              L("screen/bht2") // Never rendered.
            ),
            Array(
              L("screen/bhb2"),
              L("screen/bhb2"), // Never rendered.
              L("screen/bmr"),
              L("screen/bmr"),
              L("screen/bhm2"),  // Never rendered.
              L("screen/bhm2")
            )
          ),
          // Right.
          Array(
            Array(
              L("screen/bht2"), // Never rendered.
              L("screen/bht2"),
              L("screen/bbl"),
              L("screen/bbl"),
              L("screen/bhb2"),
              L("screen/bhb2") // Never rendered.
            ),
            Array(
              L("screen/bhm2"),
              L("screen/bhm2"), // Never rendered.
              L("screen/bbm"),
              L("screen/bbm"),
              L("screen/bhb2"),
              L("screen/bhb2") // Never rendered.
            ),
            Array(
              L("screen/bhb2"),
              L("screen/bhb2"), // Never rendered.
              L("screen/bbr"),
              L("screen/bbr"),
              L("screen/bhb2"),  // Never rendered.
              L("screen/bhb2")
            )
          )
        )
      )

      val MultiFront = Array(
        // Vertical.
        Array(
          Array(
            L("screen/ftl"),
            L("screen/ftm"),
            L("screen/ftr")
          ),
          Array(
            L("screen/fml"),
            L("screen/fmm"),
            L("screen/fmr")
          ),
          Array(
            L("screen/fbl2"),
            L("screen/fbm2"),
            L("screen/fbr2")
          )
        ),
        // Horizontal.
        Array(
          Array(
            L("screen/ftl"),
            L("screen/ftm"),
            L("screen/ftr")
          ),
          Array(
            L("screen/fml"),
            L("screen/fmm"),
            L("screen/fmr")
          ),
          Array(
            L("screen/fbl"),
            L("screen/fbm"),
            L("screen/fbr")
          )
        )
      )

      // The hacks I do for namespacing...
      private[Block] def makeSureThisIsInitialized() {}
    }
    Screen.makeSureThisIsInitialized()

    def bind(): Unit = Minecraft.getMinecraft.renderEngine.bindTexture(TextureMap.locationBlocksTexture)

    def unbind(): Unit = GlStateManager.bindTexture(0)

    def getSprite(location: ResourceLocation) = Minecraft.getMinecraft.getTextureMapBlocks.getAtlasSprite(location.toString)

    override protected def basePath = "blocks/%s"

    override protected def loader(map: TextureMap, loc: ResourceLocation) = map.registerSprite(loc)
  }

  @SubscribeEvent
  def onTextureStitchPre(e: TextureStitchEvent.Pre): Unit = {
    Font.init(e.map)
    GUI.init(e.map)
    Icons.init(e.map)
    Model.init(e.map)
    Block.init(e.map)
  }

  abstract class TextureBundle {
    private val locations = mutable.ArrayBuffer.empty[ResourceLocation]

    protected def textureManager = Minecraft.getMinecraft.getTextureManager

    final def init(map: TextureMap): Unit = {
      locations.foreach(loader(map, _))
    }

    protected def L(name: String) = {
      val location = new ResourceLocation(Settings.resourceDomain, String.format(basePath, name))
      locations += location
      location
    }

    protected def basePath: String

    protected def loader(map: TextureMap, loc: ResourceLocation): Unit
  }

}
