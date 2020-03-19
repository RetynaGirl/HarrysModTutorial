package com.teknoserval.harrysmod112.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

	public static enum OreType implements IStringSerializable {

		COPPER(0, "copper"), ALUMINUM(1, "aluminum");

		private static final OreType[] META_LOOKUP = new OreType[values().length];
		private final int meta;
		private final String name, unlocalizedName;

		private OreType(int meta, String name) {

			this(meta, name, name);

		}

		private OreType(int meta, String name, String unlocalizedName) {

			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;

		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}

		public int getMeta() {

			return this.meta;

		}

		public String getUnlocalizedName() {

			return this.unlocalizedName;

		}

		public String toString() {

			return this.name;

		}

		public static OreType byMetadata(int meta) {

			return META_LOOKUP[meta];

		}

		static {

			for (OreType enumtype : values()) {

				META_LOOKUP[enumtype.getMeta()] = enumtype;

			}

		}

	}

	public static enum WoodType implements IStringSerializable {

		MAHOGANY(0, "mahogany"), CEDAR(1, "cedar"), WILLOW(2, "willow");

		private static final WoodType[] META_LOOKUP = new WoodType[values().length];
		private final int meta;
		private final String name, unlocalizedName;

		private WoodType(int meta, String name) {

			this(meta, name, name);

		}

		private WoodType(int meta, String name, String unlocalizedName) {

			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;

		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}

		public int getMeta() {

			return this.meta;

		}

		public String getUnlocalizedName() {

			return this.unlocalizedName;

		}

		public String toString() {

			return this.name;

		}

		public static WoodType byMetadata(int meta) {

			return META_LOOKUP[meta];

		}

		static {

			for (WoodType woodtype : values()) {

				META_LOOKUP[woodtype.getMeta()] = woodtype;

			}

		}

	}

}
