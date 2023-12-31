USE [Tokoku]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](200) NOT NULL,
	[Role] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[IdCustomer] [bigint] NOT NULL,
	[IdProduct] [bigint] NOT NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK__Cart__DB43864AD7C66CF2] PRIMARY KEY CLUSTERED 
(
	[IdCustomer] ASC,
	[IdProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[description] [varchar](255) NULL,
	[img] [varchar](255) NULL,
 CONSTRAINT [PK__Categori__3214EC0712EF7CBE] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerAddress]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerAddress](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CustomerId] [bigint] NOT NULL,
	[Address] [varchar](100) NOT NULL,
	[City] [varchar](50) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](200) NOT NULL,
	[FirstName] [varchar](200) NOT NULL,
	[LastName] [varchar](200) NULL,
	[BirthDate] [date] NOT NULL,
	[Gender] [varchar](100) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
	[RegisterDate] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Deliveries]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deliveries](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[CompanyName] [varchar](100) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
	[Cost] [money] NOT NULL,
 CONSTRAINT [PK_Deliveries] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Invoice] [varchar](20) NOT NULL,
	[idProduct] [bigint] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Cost] [money] NOT NULL,
	[Discount] [money] NULL,
 CONSTRAINT [PK__OrderDet__6F2DFD0266A3B5B1] PRIMARY KEY CLUSTERED 
(
	[Invoice] ASC,
	[idProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Invoice] [varchar](20) NOT NULL,
	[IdCustomer] [bigint] NOT NULL,
	[OrderDate] [date] NOT NULL,
	[ShippedDate] [date] NOT NULL,
	[DueDate] [date] NOT NULL,
	[ReceiveDate] [date] NULL,
	[description] [varchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[Invoice] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](500) NOT NULL,
	[IdShop] [bigint] NOT NULL,
	[IdCategory] [bigint] NOT NULL,
	[Description] [varchar](500) NULL,
	[Price] [money] NOT NULL,
	[Stock] [int] NULL,
	[Image] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sellers]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sellers](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](200) NOT NULL,
	[FirstName] [varchar](200) NOT NULL,
	[LastName] [varchar](200) NULL,
	[BirthDate] [date] NOT NULL,
	[Gender] [varchar](100) NOT NULL,
	[Phone] [varchar](20) NOT NULL,
	[RegisterDate] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shop]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shop](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[IdSeller] [bigint] NOT NULL,
	[ShopName] [varchar](500) NOT NULL,
	[Detail] [varchar](250) NULL,
	[Address] [varchar](500) NOT NULL,
	[City] [varchar](100) NOT NULL,
	[RegisterDate] [date] NOT NULL,
	[ImagePath] [varchar](100) NULL,
	[DeleteDate] [date] NULL,
 CONSTRAINT [PK__Shop__3214EC07CD4724CC] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([Username], [Password], [Role]) VALUES (N'abul', N'$2a$11$HqH7f3DLkzP.WKtp4CmOLeAF6VyKLSI7nhN7dCFFSiXsncU6Ml3mK', N'Administrator')
INSERT [dbo].[Account] ([Username], [Password], [Role]) VALUES (N'firman', N'$2a$10$6ahEU25Y6kzJC8IalQaoAOTgq5XReDNwzGyleOi0.H5k2He6ejlJS', N'seller')
INSERT [dbo].[Account] ([Username], [Password], [Role]) VALUES (N'ihsan', N'$2a$10$pFvPYG/aMRMGPIlY2.bgBOp3tcd3jdkxqSn60pfVU/keImGreYGE6', N'Seller')
INSERT [dbo].[Account] ([Username], [Password], [Role]) VALUES (N'indra', N'$2a$10$lETzKcKBiiQ2VcpkaOwpg.4N27FL32iFKhMLaWsFhZ61s7EDazxuq', N'customer')
INSERT [dbo].[Account] ([Username], [Password], [Role]) VALUES (N'sansan', N'$2a$11$HqH7f3DLkzP.WKtp4CmOLeAF6VyKLSI7nhN7dCFFSiXsncU6Ml3mK', N'Seller')
INSERT [dbo].[Account] ([Username], [Password], [Role]) VALUES (N'wisnu', N'$2a$11$HqH7f3DLkzP.WKtp4CmOLeAF6VyKLSI7nhN7dCFFSiXsncU6Ml3mK', N'Customer')
GO
INSERT [dbo].[Cart] ([IdCustomer], [IdProduct], [Quantity]) VALUES (1, 1, 1)
INSERT [dbo].[Cart] ([IdCustomer], [IdProduct], [Quantity]) VALUES (1, 2, 1)
INSERT [dbo].[Cart] ([IdCustomer], [IdProduct], [Quantity]) VALUES (1, 5, 1)
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (1, N'Makanan', N'Makanan enak banget', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (2, N'Elektronik', N'Handphone, camera, komputer,laptop dan perlengkapan elektronik lainnya.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (3, N'Fashion', N'Busana dan accessories untuk pria dan wanita.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (4, N'Buku', N'Segala macam buku baik hard copy maupun digital e-book.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (5, N'Mainan', N'Macam-macam mainan, koleksi dan barang-barang hobby lainnya.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (6, N'Dapur', N'Peralatan masak dan peralatan dapur lainnya.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (7, N'Musik', N'Alat-alat musik dan perlengkapan audio lainnya.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (8, N'Kesehatan', N'Obat, supplement, dan jenis-jenis vitamin lainnya.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (9, N'Stationary', N'Peralatan kantor, kuliah dan sekolah seperti alat tulis dan lain-lain.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (10, N'Pertukangan', N'Alat-alat pembangunan dan crafting.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (11, N'Furniture', N'Lemari, meja, kursi dan furniture untuk interior lainnya.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (12, N'Rumah Tangga', N'Peralatan dan perlengkapan untuk interior rumah atau apartment.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (13, N'Ibu & Bayi', N'Berbagai macam perlengkapan bayi', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (14, N'Kecantikan', N'Aksesories, make up dan produk-produk perawatan.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (15, N'Gaming', N'Voucher, CD, console dan product-product yang berkaitan dengan video game.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (16, N'Outdoor', N'Perlengkapan camping, outdoor sport dan peralatan survival lainnya.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (17, N'Hewan Peliharaan', N'Product-product yang berkaitan dengan hewan peliharaan, mulai dari makanan sampai accessories.', N'cat-1.jpg')
INSERT [dbo].[Categories] ([Id], [Name], [description], [img]) VALUES (18, N'Tanaman dan Taman', N'Segala product yang berkaitan dengan taman dan pemeliharaan tanaman.', N'cat-1.jpg')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[CustomerAddress] ON 

INSERT [dbo].[CustomerAddress] ([Id], [CustomerId], [Address], [City], [Phone]) VALUES (1, 1, N'Jakarta', N'Jakarta', N'735246514')
SET IDENTITY_INSERT [dbo].[CustomerAddress] OFF
GO
SET IDENTITY_INSERT [dbo].[Customers] ON 

INSERT [dbo].[Customers] ([Id], [Username], [Password], [FirstName], [LastName], [BirthDate], [Gender], [Phone], [RegisterDate]) VALUES (1, N'wisnu', N'$2a$11$HqH7f3DLkzP.WKtp4CmOLeAF6VyKLSI7nhN7dCFFSiXsncU6Ml3mK', N'wisnu', N'tama', CAST(N'1998-10-10' AS Date), N'Male', N'0987654', CAST(N'2023-02-10' AS Date))
INSERT [dbo].[Customers] ([Id], [Username], [Password], [FirstName], [LastName], [BirthDate], [Gender], [Phone], [RegisterDate]) VALUES (3, N'indra', N'$2a$10$exWofyeWVaGmlaeyGgQvl.XiVa4/qcsC6uHH5iEC7RMtjKujAnoJi', N'indra', N'ramadhan', CAST(N'2023-05-01' AS Date), N'male', N'08222929', CAST(N'2023-05-03' AS Date))
SET IDENTITY_INSERT [dbo].[Customers] OFF
GO
SET IDENTITY_INSERT [dbo].[Deliveries] ON 

INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (1, N'JNE', N'0778 - 5705333', 9000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (2, N'J&T', N'(021) 5651215', 9000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (3, N'POS Indonesia', N'(021) -161', 10000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (4, N'TIKI', N'(021) 44555011', 10000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (5, N'Si Cepat', N'(021) 50200050', 8000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (6, N'Pahala Express', N'(021) 5323023', 12000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (7, N'Wahana', N'0852-7565-1666', 10000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (8, N'Ninja Express', N'2926 4120', 6000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (9, N'Indah Logistik', N'0812-8839-0559', 12000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (10, N'Pandu Logistik', N'58355117', 9000.0000)
INSERT [dbo].[Deliveries] ([Id], [CompanyName], [Phone], [Cost]) VALUES (11, N'Cahaya logistik', N'7313111', 6000.0000)
SET IDENTITY_INSERT [dbo].[Deliveries] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([Id], [Name], [IdShop], [IdCategory], [Description], [Price], [Stock], [Image]) VALUES (1, N'Chitato', 1, 1, N'Snack kentang', 5400.0000, 200, N'product-1.jpg')
INSERT [dbo].[Products] ([Id], [Name], [IdShop], [IdCategory], [Description], [Price], [Stock], [Image]) VALUES (2, N'Astor', 1, 1, N'Snack wafer panjang berisikan coklat', 12000.0000, 340, N'product-1.jpg')
INSERT [dbo].[Products] ([Id], [Name], [IdShop], [IdCategory], [Description], [Price], [Stock], [Image]) VALUES (3, N'Torabika', 1, 1, N'Kopi bubuk dalam saset', 10000.0000, 120, N'product-1.jpg')
INSERT [dbo].[Products] ([Id], [Name], [IdShop], [IdCategory], [Description], [Price], [Stock], [Image]) VALUES (4, N'Jajanan', 1, 1, N'ini jajanan', 5000.0000, 4, N'product-1.jpg')
INSERT [dbo].[Products] ([Id], [Name], [IdShop], [IdCategory], [Description], [Price], [Stock], [Image]) VALUES (5, N'Makanan', 1, 1, N'asd', 50000.0000, 4, N'product-1.jpg')
INSERT [dbo].[Products] ([Id], [Name], [IdShop], [IdCategory], [Description], [Price], [Stock], [Image]) VALUES (6, N'Jajanan Lain', 1, 1, N'ini jajanan', 50000.0000, 4, N'product-1.jpg')
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[Sellers] ON 

INSERT [dbo].[Sellers] ([Id], [Username], [Password], [FirstName], [LastName], [BirthDate], [Gender], [Phone], [RegisterDate]) VALUES (1, N'sansan', N'$2a$11$HqH7f3DLkzP.WKtp4CmOLeAF6VyKLSI7nhN7dCFFSiXsncU6Ml3mK', N'ahmad', N'insan', CAST(N'1998-10-10' AS Date), N'Male', N'0987654', CAST(N'2023-02-10' AS Date))
INSERT [dbo].[Sellers] ([Id], [Username], [Password], [FirstName], [LastName], [BirthDate], [Gender], [Phone], [RegisterDate]) VALUES (2, N'firman', N'$2a$10$tCwEdaWDuk.0kBafxda8ouRnf1afqOuGPArv6EugjpsYggpqfmM9O', N'firman', N'manalu', CAST(N'2023-05-03' AS Date), N'male', N'098765123', CAST(N'2023-05-03' AS Date))
INSERT [dbo].[Sellers] ([Id], [Username], [Password], [FirstName], [LastName], [BirthDate], [Gender], [Phone], [RegisterDate]) VALUES (3, N'ihsan', N'$2a$10$J.jD9JOtguuR/QrgsC6pLeY0XLGOvdYLH828tUobf8rtqCiRGxNsu', N'ihsan', N'lah', CAST(N'2023-05-03' AS Date), N'male', N'0987654', CAST(N'2023-05-24' AS Date))
SET IDENTITY_INSERT [dbo].[Sellers] OFF
GO
SET IDENTITY_INSERT [dbo].[Shop] ON 

INSERT [dbo].[Shop] ([Id], [IdSeller], [ShopName], [Detail], [Address], [City], [RegisterDate], [ImagePath], [DeleteDate]) VALUES (1, 1, N'toko wisnu', NULL, N'jakarta barat', N'DKI Jakarta', CAST(N'2023-02-15' AS Date), NULL, NULL)
INSERT [dbo].[Shop] ([Id], [IdSeller], [ShopName], [Detail], [Address], [City], [RegisterDate], [ImagePath], [DeleteDate]) VALUES (2, 3, N'toko pak edi', NULL, N'asd', N'asd', CAST(N'2020-10-10' AS Date), NULL, NULL)
INSERT [dbo].[Shop] ([Id], [IdSeller], [ShopName], [Detail], [Address], [City], [RegisterDate], [ImagePath], [DeleteDate]) VALUES (3, 3, N'toko pak bambang', N'di toko pak bambang semua ada apakah kmau mau belkanja disnin', N'Jalan Kuri no.9 Sebelah rumah kaido', N'Wano', CAST(N'2023-05-26' AS Date), N'de8b9114-f265-4af8-b7a5-e9dbd1a9c3af.jpg', NULL)
SET IDENTITY_INSERT [dbo].[Shop] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_Categories_Name]    Script Date: 15/06/2023 14:55:02 ******/
ALTER TABLE [dbo].[Categories] ADD  CONSTRAINT [UQ_Categories_Name] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_Customers_Username]    Script Date: 15/06/2023 14:55:02 ******/
ALTER TABLE [dbo].[Customers] ADD  CONSTRAINT [UQ_Customers_Username] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_Product_Name]    Script Date: 15/06/2023 14:55:02 ******/
ALTER TABLE [dbo].[Products] ADD  CONSTRAINT [UQ_Product_Name] UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_Sellers_Username]    Script Date: 15/06/2023 14:55:02 ******/
ALTER TABLE [dbo].[Sellers] ADD  CONSTRAINT [UQ_Sellers_Username] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_IdCustomer] FOREIGN KEY([IdCustomer])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_IdCustomer]
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_IdProduct] FOREIGN KEY([IdProduct])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_IdProduct]
GO
ALTER TABLE [dbo].[CustomerAddress]  WITH CHECK ADD  CONSTRAINT [FK_CustomerAddress_Customers] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[CustomerAddress] CHECK CONSTRAINT [FK_CustomerAddress_Customers]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_IdProduct] FOREIGN KEY([idProduct])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetail_IdProduct]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_invoice] FOREIGN KEY([Invoice])
REFERENCES [dbo].[Orders] ([Invoice])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_invoice]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Order_IdCustomer] FOREIGN KEY([IdCustomer])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Order_IdCustomer]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Product_IdCategory] FOREIGN KEY([IdCategory])
REFERENCES [dbo].[Categories] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Product_IdCategory]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Product_IdShop] FOREIGN KEY([IdShop])
REFERENCES [dbo].[Shop] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Product_IdShop]
GO
ALTER TABLE [dbo].[Shop]  WITH CHECK ADD  CONSTRAINT [FK_Shop_IdSeller] FOREIGN KEY([IdSeller])
REFERENCES [dbo].[Sellers] ([Id])
GO
ALTER TABLE [dbo].[Shop] CHECK CONSTRAINT [FK_Shop_IdSeller]
GO
/****** Object:  StoredProcedure [dbo].[ShopBySeller]    Script Date: 15/06/2023 14:55:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ShopBySeller]
(@sellerName AS varchar(100),@shopName AS varchar(100))
AS
BEGIN

select CONCAT(se.FirstName, ' ',se.LastName) fullName, se.Phone,sh.ShopName,sh.City,CONCAT(sh.Address,', ',sh.City) [Address]  from Shop as sh
left join Sellers as se on se.Id=sh.IdSeller
where CONCAT(se.FirstName, ' ',se.LastName) like '%'+@sellerName+'%' or sh.ShopName like '%'+@shopName+'%'

END
GO
